package it.esedra.corso.marco.desktopPc;

/**
 * Questa classe deriva dalla classe DesktopPc, e permette di creare i modelli
 * di assemblaggio pc
 * 
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

		return "PC's Core Assembly ===> " + getMotherboardFormat() + " - " + getMotherboardVendorName() + " - "
				+ getMotherboardCpuSocketType() + " - " + getCpuVendorName() + " - " + getCpuClock();

	}

	public String getGpuAssembly() {

		return "Graphics Assenbly ===> " + getGraphicCardVendorName();

	}

	public String getHardDrivesAssembly() {

		return "Hard Drives Assembly ===> " + getHddType() + " - " + getHddCapacity();

	}

	/**
	 * Questo metodo fa l'overload del metodo getGpuAssembly e permette di ricevere
	 * anche la quantità di memoria e il tipo di chip grafico della scheda grafica
	 * 
	 * @return String restituisce le specifiche della scheda grafica come nel metodo
	 *         getGpuAssembly, ma con l'aggiunta della memoria e del tipo di chip
	 *         grafico
	 */
	public String getGpuAssemblyExtended() {

		return "Graphics Assenbly ===> " + getGraphicCardVendorName() + " - " + getGraphicsCardMemory() + " - "
				+ getGraphicsCardChipType();

	}

}
