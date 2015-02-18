#include <iostream>
#include <algorithm>
#include<cstring>

using namespace std;

string theAlphabet = "abcdefghijklmnopqrstuvwxyz";

string toLower(string str)
{
	for(int i = 0; i < str.length(); i++)
	{
		if(str[i] >= 'A' && str[i] <= 'Z')
		{
			str[i] = str[i] - ('A' - 'a');
		}
	}
	return str;
}


bool member (string str,char elem)
{
    for(int i=0; i < str.length(); i++)
    {
        if(str[i] == elem)
        return true;
    }
    return false;
}

bool containsAlphabet (string str)
{
  string alphabet = "";
  for( int i=0; i<str.length(); i++)
  {
      if((member(theAlphabet,str[i])) && !(member(alphabet,str[i])))
         {
           alphabet.push_back(str[i]);
         }
  }

   sort(alphabet.begin(),alphabet.end());
   if (alphabet.compare(theAlphabet) == 0)
   {
       return true;
   }
   else
   {
       return false;
   }

}
string substringContainAlphabet(int index,string str)
{
    string alphalist = theAlphabet;

    string substring = "";

    for (int i=index; i < str.length(); i++)
        if( member(alphalist,str[i]) && !alphalist.empty())
            {
                substring.push_back(str[i]);
                int findedIndex = alphalist.find(str[i]);

                alphalist.erase(alphalist.begin() + findedIndex);

            }

        else
            if(!member(alphalist,str[i]) && !alphalist.empty())
                {
                    substring.push_back(str[i]);
                }

    if(containsAlphabet(substring))
        return substring;
    else
        return "";
}

string smallestSubstringContainAlphabet(string str)
{
    str = toLower(str);
    int index = 0;
    string minString = substringContainAlphabet(index, str);
    while (index != str.length())
     {
        index += 1;
        string newString = substringContainAlphabet(index, str);

        if ((newString.length() < minString.length()) && (containsAlphabet(newString)))
           {
               minString = newString;
           }
     }

    return minString;
}
int main()
{
    string str = "abcdefghiJklmn124345678!@#$%^&*opQrstuVwxyz!*abCdefgHijklmn";
    cout << smallestSubstringContainAlphabet(str);
    return 0;
}
