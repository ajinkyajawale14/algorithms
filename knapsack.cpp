/*
 * knapsack.cpp
 *
 *  Created on: Jan 27, 2019
 *      Author: HP
 */
#include <iostream>
#include <algorithm>
using namespace std;

struct Item{
	int weight; int value;
	Item(int value, int weight ): value(value), weight(weight){}
};

bool cmp(struct Item a, struct Item b)
{
	double r1 = (double)a.value / a.weight;
	double r2 = (double)b.value / b.weight;
	return r1>r2;
}
double knapsack(int w , Item arr[] ,int n){

	//sort the value based on the fraction
	sort(arr,arr+n,cmp);

	//display the fraction values
	for (int i = 0; i < n ; i++ )
	{
		cout<<arr[i].value << " " <<arr[i].weight << " : "
				<<((double)arr[i].value / arr[i].weight ) << endl;
	}

	int currentweight = 0;
	double finalvalue = 0;

	//loop
	for(int i=0;i<n;i++)
	{
		if(currentweight + arr[i].weight <= w)
		{
			currentweight +=arr[i].weight;
			finalvalue += arr[i].value;
		}

	//if not
	else
	{
		int remain = w - currentweight;
		finalvalue += arr[i].value * ((double) remain /arr[i].weight);
	break;
	}
	}
	return finalvalue;
}
int main()
{
	int w =50;
	Item arr[] = { {60,10},{100,20},{120,30} };
	int n = sizeof(arr) / sizeof(arr[0]);
	cout<<"max value we can obtain: " << knapsack(w,arr,n);
	return 0;
}
