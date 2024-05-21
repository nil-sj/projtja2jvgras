package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertEquals("Product tester", job.getName());
        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());
        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());
        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(false, job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue("String stars with a new line", job.toString().startsWith(System.lineSeparator()));
        assertTrue("String ends with a new line", job.toString().endsWith(System.lineSeparator()));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedJobString = System.lineSeparator()
                + "ID: " + job.getId()
                + "\nName: " + "Product tester"
                + "\nEmployer: " + "ACME"
                + "\nLocation: " + "Desert"
                + "\nPosition Type: " + "Quality control"
                + "\nCore Competency: " + "Persistence"
                + System.lineSeparator();
        assertEquals(expectedJobString, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        String expectedJobString = System.lineSeparator()
                + "ID: " + job.getId()
                + "\nName: " + "Product tester"
                + "\nEmployer: " + "ACME"
                + "\nLocation: " + "Desert"
                + "\nPosition Type: " + "Quality control"
                + "\nCore Competency: " + "Data not available"
                + System.lineSeparator();
        assertEquals(expectedJobString, job.toString());
    }

    @Test
    public void testToStringHandlesIdOnly() {
        Job job = new Job();
        assertEquals("OOPS! This job does not seem to exist.", job.toString());
    }

}
