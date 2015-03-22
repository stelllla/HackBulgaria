package hackbulgaria.corejava.week0;

import java.util.Arrays;

    public class UPJava 
    {
        
        public boolean isOdd(int n)
        {
            return (n%2 != 0);
        }
        
       
        public boolean isPrime (int n)
        {
            int sqrtN = (int) Math.sqrt(n);
            for(int i = 2; i < sqrtN; i++)
                if(n % i == 0)
                    return false;
            
            return true;
        }
        
        
        public int minElem (int[] array)
        {
            int min = Integer.MAX_VALUE;
            for(int elem : array )
                if( min > elem)
                  min = elem;
            
            return min;
        }
        
        public int kthMin(int k, int[] array)
        {
            Arrays.sort(array);
            return array[k-1];
        }
        
        public float getAverage(int[] array)
        {
            float sum = 0;
            for ( int elem : array)
                sum += elem;
            
            return sum/array.length; 
        }
        
        public long DoubleFac(long n)
        {
            long fact = 1;
            int count = 0;
            while ( count != 2)
            {
                if ( n == 0)
                {
                    n = fact;
                    fact = 1;
                    count ++;
                }
                else 
                {
                    fact = fact * n;
                    n--;
                }
            }
            return n;
            
        }
       
//        public static BigInteger Doublefac(int n)
//        {
//            int fact = 1;
//            while ( n > 0)
//            {
//                fact *= n;
//                n--;
//            }
//            
//            BigInteger fact1 = BigInteger.ONE;
//            while ( fact > 0)
//            {
//                fact1 = fact1.multiply(BigInteger.valueOf(fact));
//                fact--;
//            }
//            
//            return fact1;
//            
//        }
        
        public long kthFac(int k, int n)
        {
            long fact = 1;
            while ( n > 0)
            {
                fact *= n;
                n = n- k;
            }
            
            return fact;
        }
        
        public long gcd(long a, long b)
        {
            return b == 0 ? a : gcd(b, a % b);
        }
        
        public long getSmallestMultiple (int upperBound)
        { 
           if (upperBound == 2) return 2;
              else 
                  {
                      long b = getSmallestMultiple(upperBound - 1);
                      return (upperBound - 1) * b / gcd(upperBound - 1, b);
                   }
         }
            
        public long getLargestPalindrome(long N)
        {
            long i = 0;
            for( i = (N-1); i > 0; i--)
            {
                if ( isPalindrome(i))
                    break;
            }
            return i;
            
        }
        
        public int[] histogram(short[][] image)
        {
            int[] result = new int[256];
            int rows = image.length,cols = image[0].length;
                
            for( int i = 0; i < rows; i++ )
              for( int j = 0; j < cols; j++) {
                result[image[i][j]] ++;
               }
       
              return result;
        }
        
        public long pow(int a, int b)
        {
            if ( b == 0)
            {
                return 1;
            }
            if ( b % 2 == 0)
            {
                return pow (a, b/2) * pow (a, b/2);
            }
            else
                return a * pow (a, b-1);
            
        }

        public int getOddOccurrence(int[] array)
        {
            Arrays.sort(array);
            
            int i = 0,count = 1;
            while (i+1 != array.length){   
                if( array[i] == array[i + 1] ){
                    count ++;
                    i ++;
                 } 
                else{
                    
                    if ( isOdd(count)){
                        break;
                    }
                  
                    i++;
                    count = 1;
                   }
            }
            
            return array[i];
        }
        
       
        public  long maximalScalarSum(int[] a, int[] b)
        {
          Arrays.sort(a);
          Arrays.sort(b);
          
          long scalar = 0;
          
            for ( int i = 0; i< a.length; i++)
                scalar += a[i]*b[i];
            
            return scalar;
            
        }
        
      public int maxElem ( int[] numbers)
      {
          int max = numbers[0];
          for ( int i = 1; i < numbers.length; i++)
          {
              if ( max < numbers[i])
                  max = numbers[i];
          }
          return max;
      }
  
      public int maxSpan(int[] numbers)
      {
          int[] spans = new int[numbers.length];
          
          for ( int i = 0; i <numbers.length; i++) 
          {
              int elem = numbers[i];
              int span = 1;
              for ( int j = numbers.length -1; j > i; j--)
              {
                  if ( numbers[j] == elem)
                  {
                      span = j - i + 1;
                      break;
                  }
              }
              spans[i] = span;
          }
          
          return maxElem(spans);
      }
      
      public int sumElements (int[] array,int from,int to){
          int sum = 0;
          for ( int i = from; i <= to; i++){
              sum+=array[i];
          }
          return sum;
      }
    
        public boolean canBalance(int[] numbers)
        {
            if( numbers.length == 2 && numbers[0] == numbers[1] ){
                    return true;
               }
            int sumAll = sumElements( numbers,0,numbers.length - 1);
            for ( int i = 1; i < numbers.length; i++){
                int partSum = sumElements(numbers,0,i);
                if ( partSum == sumAll - partSum)
                    return true;
            }
      
             return false;
        }
       
 //average   
        public int[][] rescale(int[][] original, int newWidth, int newHeight)
        {
            int oldWidth = original.length;
            
            double changeValue = (double) newWidth / oldWidth;
            
            int[][] newImage = new int[newWidth][newHeight];
            
            for ( int i = 0; i < newWidth; i ++)
                for (int j = 0; j < newHeight; j++)
                {
                    newImage[i][j] = original [(int)( i/changeValue)][(int)( j/changeValue)];
                }
            
            return newImage;
          
        }
        
        public String reverseMe (String argument)
        {
            StringBuilder reversed = new StringBuilder();
            for ( int i = argument.length() - 1; i >= 0; i--)
            {
                reversed.append(argument.charAt(i));
            }
            
            return reversed.toString();
            
        }
        
        public String reverseEveryWord(String arg)
        {
           String[] arrayString = arg.split(" ");
           StringBuilder result = new StringBuilder();
           
           for ( int i = 0; i < arrayString.length; i++) {
               if ( i == arrayString.length - 1){
                   result.append(reverseMe(arrayString[i]));
               }
               else {
                   
               result.append(reverseMe(arrayString[i]));
               result.append(" ");
               }
           }
           
           return result.toString();
        }
        
        public boolean isPalindrome(String argument)
        {
            return (argument.equals(reverseMe(argument)));
        }
        
        public  boolean isPalindrome(long argument)
        {
            long originalNum = argument;
            long reversedNum = 0;
            
            while ( originalNum > 0)
            {
                int digit = (int) originalNum % 10;
                reversedNum = reversedNum*10 + digit;
                originalNum/=10;
                
            }
            return (argument == reversedNum);
        }
        
        public String copyEveryChar(String input, int k)
        {
            StringBuilder result=new StringBuilder("");
            char[] chars =  input.toCharArray();
            for ( int i = 0; i < chars.length; i++)
                for (int j = 0; j < k; j++)
                {
                    result.append(chars[i]);
                }
            
            return result.toString();
        }
        
        public int getPalindromeLength(String input)
        {
            int index = input.indexOf('*');
            int count = 0;
            int beforeIndex = index -1, afterIndex = index + 1;
            
            
            while ( beforeIndex != -1 || afterIndex != input.length() )
            {
                if(  input.charAt(beforeIndex) == input.charAt(afterIndex))
                    {
                        count++;
            
                        beforeIndex--;
                        afterIndex++;
                    }
                else break;
            }
            
            return count;
        }
        
        public int countOcurrences(String needle, String haystack)
        {
            return (haystack.length() - haystack.replaceAll(needle,"").length()) / needle.length();
        }
        
        public String decodeURL(String input)
        {
            return input.replace("%20","").replace("%3A",":").replace("%3D", "?").replace("%2F", "/");
        }
        
        public int sumOfNumbers(String input)
        {
            Integer sum = 0;

            int i=0;
            while (i < input.length())  
            {  
                boolean flag = false;
                String number = new String();
                char elem = input.charAt(i);
                
                if (i!=0 )
                {
                    if ( input.charAt(i-1) == '-')
                        number="-";
                }
                
                while (elem >= '0' && elem <= '9')
                {
                    flag = true;
                    number = number + elem;
                
                    if ( i != input.length()-1)
                    {
                        elem = input.charAt(i+1);
                        i++;
                    }
                    else break;
                }
                
                if (flag)
                {
                      sum+=Integer.parseInt(number);
                      i++;
            
                 }
                else
                {
                    i++;
                }
            }
            
            return sum;
        }

        
        public boolean areAnagrams(String A, String B)
        {
            char[] arrayA = A.toCharArray();
            Arrays.sort(arrayA);
            
            char[] arrayB = B.toCharArray();
            Arrays.sort(arrayB);
            
            return Arrays.equals(arrayA,arrayB);
        }
        
        public boolean hasAnagramOf(String A,String B)
        {
            for ( int i = 0; i<= B.length() - A.length(); i++)
            {
                String subString = B.substring(i, i + A.length());
                if (areAnagrams(A,subString))
                {
                    return true;
                }
                        
            }
            
            return false;
        }
       
    
    }