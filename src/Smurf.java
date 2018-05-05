
public class Smurf {

	private String name;

	Smurf(String name) {
		this.name = name;
	}

	public String getName() {
		return "My name is " + name + " Smurf.";
	}

	public void eat() {
		System.out.println(name + " Smurf is eating Smurfberries.");
	}

	/* Papa Smurf wears a red hat, all the others are white. */
	public String getHatColor() {
		// 3. Fill in this method
		if(name.equalsIgnoreCase("Papa")) {
			
			return name + "Smurf wears a Red Hat.";
		}else if(name.equalsIgnoreCase("Smurfette")) {
		return name + "wears a White Hat.";
		}else {
			
			return name + "Smurf wears a White Hat.";
		}
	}

	/* Smurfette is the only female Smurf. */
	public String isGirlOrBoy() {
		// 4. Fill in this method
		
			
	if(name.equalsIgnoreCase("Smurfette")) {
			return name + " is a Girl.";
			
		}else {
		return name + "Smurf is a Boy";
		}
	}

}



