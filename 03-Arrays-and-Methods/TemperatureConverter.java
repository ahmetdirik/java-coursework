public class tempatureConverter {
	
	public static double degree;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(tempatureConverter.convert(100.0));
		System.out.println();
		System.out.println(tempatureConverter.convert(50));


		

	}
	public static double convert (double degree) {
		System.out.println("Converting to Fahrenheit");
		System.out.println(degree + " °C = " + ((degree * 1.8) + 32) + "°F");
		return (degree * 1.8 + 32);
	}

	public static int convert (int degree) {
		System.out.println("Converting to Celsius");
		System.out.println(degree + " °F = " + ((degree - 32)/1.8) + "C");
		return (int) ((degree - 32)/1.8);
	}

}
