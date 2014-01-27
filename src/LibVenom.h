//
//  LibVenom.h
//  Potent "Venom" Useful Functions
//
//  Created by Austin Jackson,
//  ruthlessphysics.com/potent/
//  Last modified on December 21, 2013.
//
//

#include <string>
#include <stdio.h>
#include <cstdlib>
#include <stdlib.h>
#include <conio.h>

using namespace std;

void pauseConsole()
{
    cout<<"Press any key to continue . . ."<<endl;
	getch();
}

string boolToString(bool A)
{
    if(A == true)
    {
        return "true";
    }
    else if(A == false)
    {
        return "false";
    }
    else
    {
        return "ERROR";
    }
}

bool charToBool(char A)
{
	if((A == 'Y' || A == 'y') || (A == 'T' || A == 't'))
	{
		return true;
	}
	else if((A == 'N' || A == 'n') || (A == 'F' || A == 'f'))
	{
		return false;
	}
	else
	{
		return false;
	}
}

int randIntBetween(int from, int to)
{
    return rand() % to + from;
}

string combineStrings(string A, string B)
{
    return A+B;
}
