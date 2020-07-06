package it.esedra.corso.marco;

/**
 * Questa classe deriva dalla classe DesktopPc, e permette di creare i modelli di assemblaggio pc
 * @author marco
 *
 */
public class DesktopPcAssembly extends DesktopPc {
	
	private String graphicsCardMemory;
	private String graphicsCardChipType;
	
	public String getGraphicsCardMemory() {
		return "Graphics Card Total Memory: " + graphicsCardMemory;
	}

	public void setGraphicsCardMemory(String graphicsCardMemory) {
		this.graphicsCardMemory = graphicsCardMemory;
	}
	
	public String getGraphicsCardChipType() {
		return "Graphics Card Chip Type: " + graphicsCardChipType;
	}

	public void setGraphicsCardChipType(String graphicsCardChipType) {
		this.graphicsCardChipType = graphicsCardChipType;
	}
	
	public String getCoreAssembly() {
		
		return "PC's Core Assembly ===> " + getMotherboardFormat() + " - " + getMotherboardVendorName() + " - " + getMotherboardCpuSocketType() + " - " + getCpuVendorName() + " - " + getCpuClock();
	
	}
	
	public String getGpuAssembly() {
		
		return "Graphics Assenbly ===> " + getGraphicCardVendorName();
		
	}
	
	public String getHardDrivesAssembly() {
		
		return "Hard Drives Assembly ===> " + getHddType() + " - " + getHddCapacity();
		
	}

	public String getGpuAssemblyExtended() {
		
		return "Graphics Assenbly ===> " + getGraphicCardVendorName() + " - " + getGraphicsCardMemory() + " - " + getGraphicsCardChipType();
		
	}
		
}
