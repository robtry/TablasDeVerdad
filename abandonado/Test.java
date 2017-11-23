class Test
{
	public static void main(String[] args)
	{
		int[][] algo = new int[2][8];
		System.out.print("Filas: "+algo.length +"\t");
		System.out.println("Columnas "+algo[0].length);
		
		for (int i=0;i<algo.length;i++)
		{
			for (int j=0;j<algo[0].length;j++)
			{
				System.out.print("("+i+","+j+")"+"\t");
			}
			System.out.println();
		}
	
	}
}