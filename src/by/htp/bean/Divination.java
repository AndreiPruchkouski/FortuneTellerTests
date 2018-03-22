package by.htp.bean;

import java.util.List;
import java.util.Random;

public class Divination {
	
	private final List<String> predictions;
	
	public Divination(List<String> predictions) {
		this.predictions = predictions;
	}

	public List<String> getPredictions() {
		return predictions;
	}
	
	public String getRandomPrediction() {
		return predictions.get(new Random().nextInt(predictions.size()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((predictions == null) ? 0 : predictions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Divination other = (Divination) obj;
		if (predictions == null) {
			if (other.predictions != null)
				return false;
		} else if (!predictions.equals(other.predictions))
			return false;
		return true;
	}
	
	
	
}
