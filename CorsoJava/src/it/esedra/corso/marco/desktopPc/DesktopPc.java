package it.esedra.corso.marco.desktopPc;

/**
 * Questa classe contiene i metodi che definiscono le componenti base del pc da
 * assemblare
 * 
 * @author marco
 *
 */
public class DesktopPc {

	private String motherboardFormat;
	private String motherboardVendorName;
	protected String motherboardCpuSocketType;
	private String cpuVendorName;
	private String cpuClock;
	private String ramVendorName;
	private String ramCapacity;
	private String graphicCardVendorName;
	private String hddType;
	private String hddCapacity;

	public String getMotherboardFormat() {
		return "Motherboard Format: " + motherboardFormat;
	}

	public void setMotherboardFormat(String motherboardFormat) {
		this.motherboardFormat = motherboardFormat;
	}

	public String getMotherboardVendorName() {
		return "Motherboard Vendor Name: " + motherboardVendorName;
	}

	public void setMotherboardVendorName(String motherboardVendorName) {
		this.motherboardVendorName = motherboardVendorName;
	}

	public String getMotherboardCpuSocketType() {
		return "Motherboard CPU Socket Type: " + motherboardCpuSocketType;
	}

	public void setMotherboardCpuSocketType(String motherboardCpuSocketType) {
		this.motherboardCpuSocketType = motherboardCpuSocketType;
	}

	public String getCpuVendorName() {
		return "CPU Vendor Name: " + cpuVendorName;
	}

	public void setCpuVendorName(String cpuVendorName) {
		this.cpuVendorName = cpuVendorName;
	}

	public String getCpuClock() {
		return "CPU Clock: " + cpuClock;
	}

	public void setCpuClock(String cpuClock) {
		this.cpuClock = cpuClock;
	}

	public String getRamVendorName() {
		return "RAM Memory Vendor Name: " + ramVendorName;
	}

	public void setRamVendorName(String ramVendorName) {
		this.ramVendorName = ramVendorName;
	}

	public String getRamCapacity() {
		return "RAM Memory Capacity (GB): " + ramCapacity;
	}

	public void setRamCapacity(String ramCapacity) {
		this.ramCapacity = ramCapacity;
	}

	public String getGraphicCardVendorName() {
		return "GPU Vendor Name: " + graphicCardVendorName;
	}

	public void setGraphicCardVendorName(String graphicCardVendorName) {
		this.graphicCardVendorName = graphicCardVendorName;
	}

	public String getHddType() {
		return "HDD Type: " + hddType;
	}

	public void setHddType(String hddType) {
		this.hddType = hddType;
	}

	public String getHddCapacity() {
		return hddCapacity;
	}

	public void setHddCapacity(String hddCapacity) {
		this.hddCapacity = hddCapacity;
	}

}