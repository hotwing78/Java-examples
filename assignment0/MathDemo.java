//File: Assignment 0
//Author: Wingo
//purpose: Math demo
package edu.trident.wingo.assignment0;

import java.util.Scanner;

import java.lang.Math;


public class MathDemo 
{
	private double x;
	private double y;
	
	public MathDemo(double num1, double num2)
	{
		x = num1;
		y = num2;
		
	}
	
	public double min ()
	{
		return Math.min(x,y);
	}
	
	public double max ()
	{
		return Math.max(x,y);
	}
	
	public double productToPower(double num1)
	{
		double pro = x * y;
		double absPro = Math.abs(pro);
		
		return Math.pow(absPro,num1);
	}
	
	public double modOfPower(double num1)
	{
		double raise = Math.pow(x,y);
		double mod = raise % num1;
		return mod;
	}
	
	public double multiplyAndSign(double num1)
	{
		double multiSign = (x*y) * Math.signum(num1);
		return multiSign;
	}
	
	public static void main(String[] args) 
	{
		@SuppressWarnings("resource")
		Scanner data = new Scanner(System.in);
		double first,second;
		double num;
		double power;
		double mod;
		double sign;
		
		MathDemo obj;
		
		System.out.println("First Number");
		first = data.nextDouble();
	
		System.out.println("Second Number");
		second = data.nextDouble();
		
		System.out.println("What number for product to power?");
		power = data.nextDouble();
		
		System.out.println("What is the mod #?");
		mod = data.nextDouble();
		
		System.out.println("What is the sign #?");
		sign = data.nextDouble();
		
		obj = new MathDemo(first,second);
		 
		num = obj.min();
		System.out.println("min: "+num);
		
		num = obj.max();
		System.out.println("max: "+num);
		
		num = obj.productToPower(power);
		System.out.println("p: "+power);
		System.out.println("ProdToPower: "+num);
		
		num = obj.modOfPower(mod);
		System.out.println("p: "+mod);
		System.out.println("PowerMod: "+num);
		
		num = obj.multiplyAndSign(sign);
		System.out.println("p: "+sign);
		System.out.println("MultAndSign: "+num);
		
		 
		 
		
		

	}


}
