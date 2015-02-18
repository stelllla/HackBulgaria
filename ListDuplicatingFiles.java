import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ListDuplicatingFiles
{
	private ArrayList<File> resultList = new ArrayList<File>();
	
	public ListDuplicatingFiles(String fileDir) throws IOException
	{
		File file = new File (fileDir);
		extractFiles(file);
		checkForDuplicates(resultList);
	}
	
	public void extractFiles (File file) throws IOException
	{
		
	      if (file.isFile()) 
	      {
	    	  resultList.add(file);
	      } 
	      else 
	    	  if (file.isDirectory()) 
	    	  	{
	    		  File[] listOfFiles = file.listFiles();
	    		  for(File fileFromList : listOfFiles)
	    			  extractFiles(fileFromList);
	    	  	}
	  }
	
	public void checkForDuplicates (ArrayList<File> resultList) throws IOException
	{
		for (int i=0; i < resultList.size(); i++)
			for (int j = i+1; j < resultList.size(); j++)
			{
				if(equalFiles(resultList.get(i),resultList.get(j)) )
						{
							resultList.remove(j);
						}
			}
	}
	
	
	public Boolean equalFiles(File file1,File file2) throws IOException
	{
		String pathFile1 = file1.toString();
		String pathFile2 = file2.toString();
		
		byte[] file1Bytes = Files.readAllBytes(Paths.get(pathFile1));
		byte[] file2Bytes = Files.readAllBytes(Paths.get(pathFile2));
		
		if (Arrays.equals(file1Bytes, file2Bytes))
		{
			return true;
		}
		
			else 
			{
				return false;
			}
	}
	
	public static void print(ArrayList<File> resultList)
	{
		if (resultList.size() > 0)
		{
			for (int i=0; i<resultList.size(); i++)
				System.out.println(resultList.get(i).getName() + "   ");
		}
		else 
			{
				System.out.println("Directory or file doesn`t exist! ");
			}
	}


	public static void main (String args[]) throws IOException 
	{
		System.out.println("Select a directory or file :");
	
		Scanner sc = new Scanner(System.in);
		String directory = sc.nextLine();
	
		sc.close();
		
	
		ListDuplicatingFiles test = new ListDuplicatingFiles(directory);
		print(test.resultList);
	}
}
   
