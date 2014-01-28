//
//  Menu.cpp
//  Potent Calculator
//
//  Created by Austin Jackson,
//  Last modified on November 2, 2013.
//
//

#include <iostream>
#include <cstdlib>
#include <math.h>
#include "Director.h"

using namespace std;

int main()
{
    //potentIntro(800,800);
    about();
    pause();
    welcome();
	pause();
	while(enabled == true)
	{		
		menu();
		switchOperation();
		if(enabled == true)
		{
            clearIns(pass);
            pause();
		}
	}
	if(enabled == false)
	{
		exit();
	}
}
