//
//  Core.h
//  Potent Calculator
//
//  Created by Austin Jackson,
//  Last modified on November 2, 2013.
//
//

#include <iostream>
#include <cstdlib>
#include <string>
#include <math.h>
#include "PotentCalculator_private.h"
#include "LibVenom.h"

using namespace std;

double inA,inB,inC,inD,inE,inF,inG,inH;
char chA,chB,chC,chD,chE,chF,chG,chH;
int iA,iB,iC,iD;
string strA,strB,strC,strD;
string operation,operation2,operation3;
char pauseChar;
int appstate = 0;
bool isWindows = false;
/*
    If you are compiling this software for Windows, please set this to true.
    If you are compiling this software for anything other than windows,
    please set this to false and comment-out any undeclared functions that
    your compiled alerts you of. These methods are likely from the
    WinBGIm (graphics.h) library. Check if WinBGIm has been ported to your OS,
    and try again without commenting out said methods. If you do this, remember to
    #include <graphics.h> at the top of this Header, but keep isWindows to false.
    WinBGIm is natively Windows only. Methods such as initwindow(), circle(),
    and closegraph() are part of WinBGIm. A PDF manual of WinBGIm should be included
    with this project so you can find exactly which functions to safely comment-out.
    -Austin
*/
const double pi = 3.14159265;

void welcome();
void menu();
void pause();
void clearIns();
void about();
void howToUse();
void config();
void derp();
void art();
void chartest(int B, int C);
void color(string colorID);
void disco(int duration, int mode);
void clearScreen();
void matrix();


void welcome()
{
    
    cout<<"\nPotent Calculator"<<endl;
	cout<<"Version: "<<VER_STRING<<endl;
    cout<<"Operating as Windows: "<<boolToString(isWindows)<<"\n"<<endl;
	cout<<"Written in C++ by Austin Jackson of Reagan High School, in Houston, Texas."<<endl;
	cout<<"Last updated on Thursday, January 23, 2013."<<endl;
	//cout<<"\nIt is recommended that you run this at a higher resolution than the default."<<endl;

	cout<<"\nThis program conducts many different kinds \nof mathermatical and geometrical operations.\n\nTo begin, follow the instructions below.\nAll inputs ARE case-sensitive.\n"<<endl;
}

void menu()
{
    //system("TITLE pCalculator -- Menu ");
    cout<<"\nNow showing BASIC MATH functions."<<endl;
	cout<<"   To perform addition, type \'+\' without quotes."<<endl;
    cout<<"   To perform subtraction, type \'-\' without quotes."<<endl;
    cout<<"   To perform multiplication, type \'*\' without quotes."<<endl;
    cout<<"   To perform division, type \'/\' without quotes."<<endl;
    cout<<"   To perform exponents, type \'pow\' without quotes."<<endl;
    cout<<"   To perform square root, type \'sqrt\' without quotes."<<endl;
    cout<<"   To perform factorials, type \'factorial\' without quotes."<<endl;

	cout<<"\nNow showing COORDINATE GEOMETRIC functions."<<endl;
	cout<<"   To calculate Distance (XY), type \'distance\' without quotes."<<endl;
	cout<<"   To calculate Midpoint (XY), type \'midpoint\' without quotes."<<endl;
	cout<<"   To calculate Slope (XY), type \'slope\' without quotes."<<endl;

	cout<<"\nNow showing PROPERTIES GEOMETRIC functions."<<endl;
	cout<<"   To calculate Circumference from radius, type \'circum\' without quotes."<<endl;
	cout<<"   To calculate Radius from circumference, type \'radius\' without quotes."<<endl;
	cout<<"   To calculate Area, type \'area\' without quotes."<<endl;
	cout<<"   To calculate Surface Area, type \'surfacearea\' without quotes."<<endl;
	cout<<"   To calculate Volume, type \'volume\' without quotes."<<endl;
	cout<<"   To classify a shape, type \'classify\' without quotes."<<endl;
	cout<<"   To perform Pythagorean Theorem, type \'pythag\' without quotes."<<endl;
	cout<<"   To perform Trigonometry functions, type \'trig\' without quotes."<<endl;
	cout<<"   To perform Polygon functions, type \'polygon\' without quotes."<<endl;
	cout<<"   To test if something is true or false, type \'tf\' without quotes."<<endl;
	
	cout<<"\n   (more functions coming soon!)"<<endl;
	
    cout<<"\nTo quit, type \'X\' without quotes."<<endl;
	cout<<"To learn about this program, type \'@\' without quotes."<<endl;
	cout<<"To learn how to use this program, type \'?\' or \'help\' without quotes."<<endl;
}

void pause()
{
    if(isWindows == true)
    {
        system("PAUSE");
        //closegraph();
    }
    else
    {
        cout << "Press any key, then Enter/Return to continue ... "; cin>>pauseChar;
    }
}

void clearIns()
{
	inA = 0;
	inB = 0;
	inC = 0;
	inD = 0;
	inE = 0;
	inF = 0;
	inG = 0;
	inH = 0;
	operation = "";
	operation2 = "";
	operation3 = "";
    chA = '0';
    chB = '0';
    chC = '0';
    chD = '0';
    chE = '0';
    chF = '0';
    chG = '0';
    chH = '0';
    iA = 0;
    iB = 0;
    iC = 0;
    iD = 0;
	pauseChar = '0';
}

void about()
{
	cout<<"+-----------------------------------------------------------------------------+"<<endl;
	cout<<"|                          ~~ Potent Calculator ~~                            |"<<endl;
	cout<<"| The Potent Calculator is a C++ console application made by high school      |"<<endl;
	cout<<"| freshman Austin Jackson, of Houston, Texas, at the age of 15. It performs   |"<<endl;
	cout<<"| the calculation of basic operations (+,-,*,/) via the Command Prompt        |"<<endl;
	cout<<"| (on Windows) or Terminal (on Mac OS X). It also features automatic          |"<<endl;
	cout<<"| calculating of such functions like exponents and square root to Geometrical |"<<endl;
	cout<<"| distance and midpoint, and many more. It is made for the convenience of     |"<<endl;
	cout<<"| others and is 100% open-source.                                             |"<<endl;
	cout<<"|                                                                             |"<<endl;
	cout<<"| ~ Find Austin Jackson at... ~             ~ Find Potent Calculator at... ~  |"<<endl;
	cout<<"|  ruthlessphysics.com/potent/                 srchub.org/p/pcalculator       |"<<endl;
	cout<<"|  twitter.com/MacPhage                                                       |"<<endl;
	cout<<"|                                                                             |"<<endl;
	cout<<"|                                                                             |"<<endl;
	cout<<"|    SPECIAL THANKS TO THE COMP-SCI & ROBOTICS TEAM AT REAGAN HIGH SCHOOL!    |"<<endl;
	cout<<"|                               GO BULLDOGS <3                                |"<<endl;
	cout<<"+-----------------------------------------------------------------------------+"<<endl;
	cout<<endl;
}

void howToUse()
{

	cout<<"+-----------------------------------------------------------------------------+"<<endl;
	cout<<"|                          ~~   HOW TO USE THE  ~~                            |"<<endl;
	cout<<"|                          ~~ Potent Calculator ~~                            |"<<endl;
	cout<<"| The Potent Calculator asks you for bits and pieces of data in order to run  |"<<endl;
	cout<<"| it's calculations. You will be prompted to enter this data, along with what |"<<endl;
	cout<<"| it is. The Potent Calculator is designed to be efficient and easy to master.|"<<endl;
	cout<<"|                                                                             |"<<endl;
	cout<<"| If the program prompts you, \'Enter a number:\' you can simply type in the    |"<<endl;
	cout<<"| number and press the ENTER/RETURN key on your keyboard. You can also, if    |"<<endl;
	cout<<"| you know what to expect afterwords, \'string\' together commands to work to   |"<<endl;
	cout<<"| your convenience. Such as typing \'+ 2 2\' instead of each individual.        |"<<endl;
	cout<<"| Doing that will apply the right input for each string (word) afterwords and |"<<endl;
	cout<<"| will return 4 as the answer. Try it!                                        |"<<endl;
	cout<<"|                                                                             |"<<endl;
	cout<<"| TRY PUTTING \'+ 2 2\' AS THE COMMAND TO GET THE RESULT OF 4.                  |"<<endl;
	cout<<"|                                                                             |"<<endl;
	cout<<"+-----------------------------------------------------------------------------+"<<endl;

}

void config()
{
    cout<<"\nThe configuration functionality of this software has not been implemented yet."<<endl;
    cout<<"But it will be!"<<endl;
    pause();
}

void derp()
{
    for(;;)
    {
        cout<<"herp derp lerp merp ferp werp qwerp serp ferp verp burp kerp yurp";
    }
}

void art()
{

    cout<<"\n";
    cout<<"+-------    +-------+   +---------+   +--------+   ++      ++   +---------+"<<endl;
    cout<<"|  ---  |   |  ---  |   +---+ +---+   | +------+   | \\     ||   +---+ +---+"<<endl;
    cout<<"| |   | |   | |   | |       | |       | |          ||\\\\    ||       | |    "<<endl;
    cout<<"|  ---  |   | |   | |       | |       | +------+   || \\\\   ||       | |    "<<endl;
    cout<<"| +-----+   | |   | |       | |       | +------+   ||  \\\\  ||       | |    "<<endl;
    cout<<"| |         | |   | |       | |       | |          ||   \\\\ ||       | |    "<<endl;
    cout<<"| |         |  ---  |       | |       | +------+   ||    \\\\||       | |    "<<endl;
    cout<<"+-+         +-------+       +-+       +--------+   ++     +-+       +-+    "<<endl;
    cout<<"\n";
    
}
void chartest(int B, int C)
{
    char charA = '0';
    int intA = 1;
    while(B > 0)
    {
        if(C == 1)
        {
            cout<<charA<<" = "<<intA<<endl;
        }
        else if(C == 0)
        {
            cout<<charA;
        }
        else if(C != 1 || C != 0)
        {
            break;
        }
        charA++;
        intA++;
        B--;
    }
    clearIns();
}
void color(string colorID)
{
    cout<<"colorID = \'"<<colorID<<"\'"<<endl;
    if(colorID == "1")
    {
        system("COLOR 1");
    }
    if(colorID == "2")
    {
        system("COLOR 2");
    }
    if(colorID == "3")
    {
        system("COLOR 3");
    }
    if(colorID == "4")
    {
        system("COLOR 4");
    }
    if(colorID == "5")
    {
        system("COLOR 5");
    }
    if(colorID == "6")
    {
        system("COLOR 6");
    }
    if(colorID == "7")
    {
        system("COLOR 7");
    }
    if(colorID == "8")
    {
        system("COLOR 8");
    }
}
void disco(int duration, int mode)
{
	cout<<"\nWARNING: IF YOU ARE PRONE TO SEIZURES, TERMINATE THIS PROGRAM NOW."<<endl;
	pause();
	while(duration > 0 && mode == 0) //FONT COLOR
    {
        system("COLOR 1");
        system("COLOR 2");
        system("COLOR 3");
        system("COLOR 4");
        system("COLOR 5");
        system("COLOR 6");
        system("COLOR 7");
        duration--;
    }
    while(duration > 0 && mode == 1) //BACKGROUND COLOR
    {
        system("COLOR 97");
        system("COLOR A7");
        system("COLOR B7");
        system("COLOR C7");
        system("COLOR D7");
        system("COLOR E7");
        system("COLOR 77");
        duration--;
    }
    if(duration == 0)
    {
		system("COLOR 07");
	}
}
void clearScreen()
{
	int i = 240;
	while(i > 0)
	{
		cout<<"\n";
		i--;
	}
}
void matrix()
{
    string username;
	string password;
	system("COLOR 0A");
	clearScreen();
	cout<<"\ninput username: ";
	cin>>username;
	cout<<"\ninput password: ";
	cin>>password;
	cout<<"\n\nwelcome to the matrix, "<<username<<"."<<endl;
}
