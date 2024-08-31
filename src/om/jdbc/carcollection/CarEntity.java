package om.jdbc.carcollection;

public class CarEntity {
	private int modelId;
	private String modelName;
	private int units;
	private int inPurchase;
	private int garage;
	public CarEntity() {
		super();
	}
	public CarEntity(int modelId, String modelName, int units, int inPurchase, int garage) {
		super();
		this.modelId = modelId;
		this.modelName = modelName;
		this.units = units;
		this.inPurchase = inPurchase;
		this.garage = garage;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public int getInPurchase() {
		return inPurchase;
	}
	public void setInPurchase(int inPurchase) {
		this.inPurchase = inPurchase;
	}
	public int getGarage() {
		return garage;
	}
	public void setGarage(int garage) {
		this.garage = garage;
	}
	@Override
	public String toString() {
		return "CarEntity [modelId=" + modelId + ", modelName=" + modelName + ", units=" + units + ", inPurchase="
				+ inPurchase + ", garage=" + garage + "]";
	}
	
	
	
	
	
	
}
