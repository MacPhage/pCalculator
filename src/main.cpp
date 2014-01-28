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
	while(appstate == 0)
	{
		menu();
		switchOperation();
		if(appstate == 0)
		{
            clearIns();
            pause();
		}
	}
	if(appstate != 0)
	{
		return appstate;
	}
}
