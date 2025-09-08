package com.mycompany.tvseriesmanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    private Series seriesApp;

    @BeforeEach
    void setUp() {
        // Initialize the Series app
        seriesApp = new Series();

        // Add some sample series
        seriesApp.getSeriesList().add(new TVSeries(101, "Overcomer", 12, 10));
        seriesApp.getSeriesList().add(new TVSeries(102, "Adventure Time", 8, 25));
    }

    // ---------------- Test Capture Series ----------------
    @Test
    void testCaptureSeries_AddNewSeries() {
        TVSeries newSeries = new TVSeries(103, "Mystery Show", 15, 12);
        seriesApp.getSeriesList().add(newSeries);
        assertTrue(seriesApp.getSeriesList().contains(newSeries));
    }

    @Test
    void testCaptureSeries_DuplicateID() {
        // Attempt to add a series with existing ID 101
        TVSeries duplicate = new TVSeries(101, "Duplicate Show", 10, 5);

        boolean exists = seriesApp.getSeriesList().stream()
                .anyMatch(s -> s.getId() == duplicate.getId());
        assertTrue(exists); // Duplicate ID exists, should not add
    }

    // ---------------- Test Search Series ----------------
    @Test
    void testSearchSeries_Found() {
        TVSeries found = seriesApp.getSeriesList().stream()
                .filter(s -> s.getId() == 101)
                .findFirst()
                .orElse(null);
        assertNotNull(found);
        assertEquals("Overcomer", found.getName());
    }

    @Test
    void testSearchSeries_NotFound() {
        TVSeries found = seriesApp.getSeriesList().stream()
                .filter(s -> s.getId() == 999)
                .findFirst()
                .orElse(null);
        assertNull(found);
    }

    // ---------------- Test Update Series ----------------
    @Test
    void testUpdateSeries_Success() {
        TVSeries series = seriesApp.getSeriesList().stream()
                .filter(s -> s.getId() == 102)
                .findFirst()
                .orElse(null);
        assertNotNull(series);

        series.setName("Adventure Time Updated");
        series.setAgeRestriction(10);
        series.setEpisodes(30);

        assertEquals("Adventure Time Updated", series.getName());
        assertEquals(10, series.getAgeRestriction());
        assertEquals(30, series.getEpisodes());
    }

    // ---------------- Test Delete Series ----------------
    @Test
    void testDeleteSeries_Success() {
        TVSeries series = seriesApp.getSeriesList().stream()
                .filter(s -> s.getId() == 101)
                .findFirst()
                .orElse(null);
        assertNotNull(series);

        seriesApp.getSeriesList().remove(series);
        assertFalse(seriesApp.getSeriesList().contains(series));
    }

    @Test
    void testDeleteSeries_NotFound() {
        TVSeries series = seriesApp.getSeriesList().stream()
                .filter(s -> s.getId() == 999)
                .findFirst()
                .orElse(null);
        assertNull(series);
    }
}
