public class Square {

	
	// Attributes
	boolean isEmpty;
	boolean isHit;
	
	//Constructor
	
	public Square() {
		this.isEmpty = true;
		this.isHit = false;
		
	}
	
	
	
	//Methods
	
	public boolean getIsHit() {
		return isHit;
	}

	public void setIsHit(boolean isHit) {
		this.isHit = isHit;
	}

	public boolean getIsEmpty() {
		return isEmpty;
	}
	public void setIsEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
}
