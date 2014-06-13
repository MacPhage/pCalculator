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

//
//  Main.cpp
//  Programming Tutorial
//
//  Created by Austin Jackson,
//  Last modified on February 16, 2014.
//

#include <iostream>

using namespace std;

int main()
{
    int X; //Initializes X
    int Y; //Initializes Y
    
    cin>>X; //Waits for user input, whatever users enters will be assigned to X
    Y = X*2+5*X+9; //Assign Y to a math expression involving X
    cout<<"Y = "<<Y<<endl; //Displays, "Y = [value of Y]"
    
    return 0; //Ends the program
}