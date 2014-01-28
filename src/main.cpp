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
    double a = 8;
    double b = 0;
    double c = a/b;
    cout<<"a="<<a<<endl;
    cout<<"b="<<b<<endl;
    cout<<"c="<<c<<endl;
    cout<<"c=a/b"<<endl;
    cout<<"isinf(a)="<<isinf(a)<<endl;
    cout<<"isinf(b)="<<isinf(b)<<endl;
    cout<<"isinf(c)="<<isinf(c)<<endl;
    pause();
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
