using System;
using static System.Math;

namespace CalculoFolha.Entidades
{
    public static class Utils
    {
        //Compara doubles
        public static bool AlmostEquals (double a, double b, double epsilon)
        {
            if (Math.Abs (a - b) < epsilon) { return true; }
            return false;
        }

        //Arredonda para baixo 
        public static double WeirdRound (double value, double decimals)
        {
            double baseNum = Math.Pow(10, decimals);
            return Math.Floor(value * baseNum) / baseNum;
        }
    }
}
