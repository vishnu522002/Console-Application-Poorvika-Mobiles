package poorvikaMobiles;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PoorvikaMobileDetails implements Serializable
{
	private String MobileBrand;
	private String MobileModel;
	private String MobileSpecifications;
	private double MobilePrice;
	private String MobileStocks;
	private int Quantity;
}
