package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    private Computer computer1;
    private Computer computer2;
    private ComputerManager computerManager;

    @Before
    public void init() {
        this.computer1 = new Computer("HP", "model1", 1500.50);
        this.computer2 = new Computer("AMD", "model2", 2500);
        this.computerManager = new ComputerManager();
    }

    @Test
    public void computerManagerConstructorShouldWorkCorrectly() {
        Assert.assertEquals(0, this.computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerShouldThrowWhenComputerIsNull() {
        this.computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerShouldThrowWhenComputerAlreadyExists() {
        this.computerManager.addComputer(this.computer1);
        this.computerManager.addComputer(this.computer1);
    }

    @Test
    public void addComputerShouldWorkCorrectly() {
        this.computerManager.addComputer(this.computer1);
        Assert.assertEquals(1, this.computerManager.getCount());
        Assert.assertEquals(this.computer1, this.computerManager.getComputers().get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeComputerShouldThrowWhenManufacturerIsNull() {
        this.computerManager.removeComputer(null, "asd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeComputerShouldThrowWhenModelIsNull() {
        this.computerManager.removeComputer("asd", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeComputerShouldThrowWhenComputerDoesNotExists() {
        this.computerManager.removeComputer("asd", "asd");
    }

    @Test
    public void removeComputerShouldWorkCorrectly() {
        this.computerManager.addComputer(this.computer1);
        this.computerManager.addComputer(this.computer2);
        Computer foundComputer = this.computerManager.removeComputer(this.computer1.getManufacturer(), this.computer1.getModel());
        Assert.assertEquals(this.computer1, foundComputer);
        Assert.assertEquals(1, this.computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputersByManufacturerShouldThrowWhenManufacturerIsNull() {
        this.computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void getComputersByManufacturerShouldWorkCorrectly() {
        this.computerManager.addComputer(this.computer1);
        this.computerManager.addComputer(this.computer2);
        List<Computer> computerList = this.computerManager.getComputersByManufacturer("HP");
        Assert.assertEquals(1, computerList.size());
        Assert.assertEquals(this.computer1, computerList.get(0));
    }
}