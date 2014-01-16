//
//  MathFunctions.h
//  Potent Calculator
//
//  Created by Austin Jackson,
//  Last modified on November 2, 2013.
//
//

#include "TrigonometryFunctions.h"

using namespace std;

double add(double A,double B)
{
    return A+B;
}

double subtract(double A,double B)
{
    return A-B;
}

double multiply(double A,double B)
{
    return A*B;
}

double divide(double A,double B)
{
    return A/B;
}

double exponents(double A,double B)
{
    return pow(A,B);
}
double squareroot(double A)
{
    return sqrt(A);
}
double factorials(double A,double B)
{
	while(A > 1)
    {
        B = B * A;
        A--;
    }
    return B;
}

//GEOMETRIC FUNCTIONS

double Distance(double X1,double Y1,double X2,double Y2)
{
	return sqrt( pow(X2-X1,2) + pow(Y2-Y1, 2) );
}
double DistanceSquareroot(double X1,double Y1,double X2,double Y2)
{
	return ( pow(X2-X1,2) + pow(Y2-Y1, 2) );
}
double DistanceRadical(double X1,double Y1,double X2,double Y2)
{
	//return ( pow(X2-X1,2) + pow(Y2-Y1, 2) );
    return 1337;
}
double Midpoint(double X1,double X2)
{
	return ( (X1+X2)/2 );
}
double SlopeDecimal(double X1,double Y1,double X2,double Y2)
{
	return ( (Y2-Y1)/(X2-X1) );
}
double SlopeFraction(double X1,double X2)
{
	return (X2-X1);
}
double Circumference(double radius)
{
	return ( 2*pi*radius );
}
double Radius(double circumference)
{
	return ( circumference/2/pi );
}

//AREA GEOMETRIC FUNCTIONS

double AreaTriangle(double base,double height)
{
    return ( (base*height)/2 );
}
double AreaParallelogram(double base,double height)
{
	return (base*height);
}
double AreaRhombus(double base,double height)
{
	return (base*height);
}
double AreaTrapezoid(double base1,double base2,double height)
{
    return ( ((base1+base2)*height)/2 );
}
double AreaCircle(double radius)
{
	return ( pi*pow(radius,2) );
}

//SURFACE AREA GEOMETRIC FUNCTIONS

double SaCube(double edgeLength)
{
	return (6*pow(edgeLength,2));
}
double SaRectPrism(double edgeA, double edgeB, double edgeC)
{
	return ( (2*edgeA*edgeB)+(2*edgeB*edgeC)+(2*edgeA*edgeC) );
}
double SaSphere(double radius)
{
	return (4*pi*pow(radius,2));
}
double SaCylinder(double radius, double height)
{
	return ( (2*pi*pow(radius,2))+(2*pi*radius*height) );
}

//VOLUME GEOMETRIC FUNCTIONS

double VolumeCube(double edgeLength)
{
	return pow(edgeLength,3);
}
double VolumeRectPrism(double edgeA, double edgeB, double edgeC)
{
	return (edgeA*edgeB*edgeC);
}
double VolumeCylinder(double radius, double height)
{
	return ( pi*pow(radius,2)*height );
}
double VolumeCone(double radius, double height)
{
	return ( 0.333*pi*pow(radius,2)*height );
}
double VolumeSphere(double radius)
{
	return ( (4/3)*pi*pow(radius,3) );
}

//COMMON GEOMETRIC FUNCTIONS

double PythagoreanTheorem(double a, double b, char solveFor)
{
    //solveFor.toUpperCase(); would be really nice to have.
    if(solveFor == 'C')
    {
        return sqrt(pow(a,2)+pow(b,2));
    }
    else if(solveFor == 'B')
    {
        return sqrt(pow(b,2)-pow(a,2));
    }
    else if(solveFor == 'c')
    {
        return sqrt(pow(a,2)+pow(b,2));
    }
    else if(solveFor == 'b')
    {
        return sqrt(pow(b,2)-pow(a,2));
    }
    else
    {
        return 0;
    }
}

string ClassifyTriangle(double a, double b, double c)
{
    //ANGLES
    string result;
    double abResult = sqrt(pow(a,2)+pow(b,2));
    if(abResult == c)
    {
        result += "RIGHT";
    }
    else if(abResult > c)
    {
        result += "ACUTE";
    }
    else if(abResult < c)
    {
        result += "OBTUSE";
    }
    //BUFFER
    result += " ";
    //SIDES
    if(a != b && a != c)
    {
        result += "SCALENE";
    }
    else if(a == b && a != c)
    {
        result += "ISOSCELES";
    }
    else if(a != b && a == c)
    {
        result += "ISOSCELES";
    }
    else if(a == b && a == c)
    {
        result += "EQUILATERAL";
    }
    return result;
}

double polyConvexInt(double sides)
{
	return ((sides-2)*180);
}

double polyPerimeterReg(double sideLength, double sideAmount)
{
	return (sideLength*sideAmount);
}

double polyAreaReg(double apothem, double sideLength, double sideAmount)
{
	return (0.5*apothem*polyPerimeterReg(sideLength,sideAmount));
}


/*/////////////////
//               //
// TRIGONOMETRY  //
//               //
*//////////////////
/*
double Trigonometry()
{
	//math
}
*/
