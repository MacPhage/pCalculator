//
//  TrigonometryFunctions.h
//  Potent Calculator
//
//  Created by Austin Jackson,
//  Last modified on November 2, 2013.
//
//

#include <iostream>
#include <cstdlib>
#include "Core.h"
using namespace std;

const double pi = 3.14159265;

double RadiansToDegrees(double valRad)
{
	return (360/(2*pi)*valRad);
}
double DegreesToRadians(double valDeg)
{
	return ((2*pi)/360*valDeg);
}

bool solveRight_validate(double sideA, double sideB, double sideC, double angleA, double angleB)
{
    // check to see if both angles were input and they don't add up to 90
    if (angleA>0 && angleB>0)
    {
		double sum = angleA + angleB;
		if (sum != 90)
        {
            cout<<"(validate_0)";
			return false;
		}
	}
	// check to see if three sides were input and it is not a real triangle
	if (sideA>0 && sideB>0 && sideC>0)
    {
		if (sideC != sqrt(pow(sideA,2)+pow(sideB,2)))
        {
			cout<<"(validate_1)";
			return false;
		}
	}
	return true;
}

void solveRight_solveForSides()
{
    if (result[0]>0)
    {
		result[1] = result[0] / tan(DegreesToRadians(result[3])); //sideB
		result[2] = result[0] / sin(DegreesToRadians(result[3])); //sideC
	}
	else if (result[1]>0)
    {
		result[0] = result[1] / tan(DegreesToRadians(result[4])); //sideA
		result[2] = result[1] / sin(DegreesToRadians(result[4])); //sideC
	}
	else if (result[2]>0)
    {
		result[0] = result[2] * sin(DegreesToRadians(result[3])); //sideA
		result[1] = result[2] * cos(DegreesToRadians(result[3])); //sideB
	}
}

void solveRight_solveForAngles()
{
    if(result[4]>0)
	{
        result[3] = 180 - 90 - result[4];
    }
    else if(result[3]>0)
	{
        result[4] = 180 - 90 - result[3];
    }
    else if (result[0]>0 && result[1]>0)
    {
		result[3] = RadiansToDegrees(atan(result[0]/result[1]));
		result[4] = RadiansToDegrees(atan(result[1]/result[0]));
	}
	else if (result[0]>0 && result[2]>0)
    {
		result[3] = RadiansToDegrees(asin(result[0]/result[2]));
		result[4] = RadiansToDegrees(acos(result[0]/result[2]));
	}
	else if (result[1]>0 && result[2]>0)
    {
		result[3] = RadiansToDegrees(acos(result[1]/result[2]));
		result[4] = RadiansToDegrees(asin(result[1]/result[2]));
	}
	else
    {
        //
	}
}

double solveRight_solveForAngleA(double sideA, double sideB, double sideC, double angleB)
{
    double angleA = 0;
    if(angleB>0)
	{
        angleA = 180 - 90 - angleB;
    }
    else if (sideA>0 && sideB>0)
    {
		angleA = RadiansToDegrees(atan(sideA/sideB));
	}
	else if (sideA>0 && sideC>0)
    {
		angleA = RadiansToDegrees(asin(sideA/sideC));
	}
	else if (sideB>0 && sideC>0)
    {
		angleA = RadiansToDegrees(acos(sideB/sideC));
	}
	else
    {
		return 0;
	}
	return angleA;
}

double solveRight_solveForAngleB(double sideA, double sideB, double sideC, double angleA)
{
    double angleB = 0;
    if(angleA>0)
	{
        angleB = 180 - 90 - angleA;
    }
    else if (sideA>0 && sideB>0)
    {
		angleB = RadiansToDegrees(atan(sideB/sideA));
	}
	else if (sideA>0 && sideC>0)
    {
			angleB = RadiansToDegrees(acos(sideA/sideC));
	}
	else if (sideB>0 && sideC>0)
    {
			angleB = RadiansToDegrees(asin(sideB/sideC));
	}
	else
    {
		return 0;
	}
	return angleB;
}

double solveRight_solveForSideA(double sideB, double sideC, double angleA, double angleB)
{
	double sideA = 0;
	if (sideB>0 && angleB>0)
    {
		sideA = sideB / tan(DegreesToRadians(angleB));
	}
	else if (sideC>0 && angleB>0)
    {
		sideA = sideC * sin(DegreesToRadians(angleA));
	}
	else
    {
        return 0;
	}
    return sideA;
}

double solveRight_solveForSideB(double sideA, double sideC, double angleA, double angleB)
{
    double sideB = 0;
    if (sideA>0 && angleA>0)
    {
		sideB = sideA / tan(DegreesToRadians(angleA));
	}
	else if (sideC>0 && angleA>0)
    {
		sideB = sideC * cos(DegreesToRadians(angleA));
	}
	else
    {
        return 0;
	}
	return sideB;
}
double solveRight_solveForSideC(double sideA, double sideB, double angleA, double angleB)
{
    double sideC = 0;
    if (sideA>0 && angleA>0)
    {
		sideC = sideA / sin(DegreesToRadians(angleA));
	}
	else if (sideB>0 && angleB>0)
    {
		sideC = sideB / sin(DegreesToRadians(angleB));
	}
	else
    {
        return 0;
	}
    return sideC;
}
