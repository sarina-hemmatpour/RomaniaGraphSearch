package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static RomaniaGraph romania=new RomaniaGraph();

    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);

        String origin,destination;

        System.out.println("Enter origin: ");
        origin=input.next();

        System.out.println("Enter destination: ");
        destination=input.next();


        ArrayList<String> visited=new ArrayList<>();
        String[] preVertex=new String[20];

        ArrayList<String> unvisited=new ArrayList<>();
        for (int i=0 ; i<20 ; i++)
        {
            unvisited.add(romania.getCitys()[i]);
        }

        int[] shortestDistence=new int[20];

        shortestDistence[romania.findIndexOfCity(origin)]=0;

        for (int i=0 ; i<20 ; i++)
        {

            if (i!=romania.findIndexOfCity(origin))
            {
                shortestDistence[i]=Integer.MAX_VALUE;
            }
        }

        int finalIndex;

        while (! stopSearching(visited , destination) )
        {
            int index=indexOfCityWithShortestDistence(shortestDistence , visited);

            for (int j=index ; j<20 ; j++)
            {
                if (romania.getMap()[index][j]==1)
                {
                    if (shortestDistence[j] > romania.getPathWeight()[index][j] + shortestDistence[index])
                    {
                        shortestDistence[j]=romania.getPathWeight()[index][j] + shortestDistence[index];

                        preVertex[j]=romania.getCitys()[index];
                    }
                }
            }

            visited.add(romania.getCitys()[index]);
            unvisited.remove(romania.getCitys()[index]);

            finalIndex=index;

        }



        ArrayList<String> cities=new ArrayList<>();

        int sum=0;

        cities.add(destination);
        int count=0;
            for (int i=0 ; !cities.get(i).equals(origin) ; i++ , count++)

        {
            cities.add(preVertex[romania.findIndexOfCity(cities.get(i))]);

            {
                sum+=romania.getPathWeight()[romania.findIndexOfCity(cities.get(i))][romania.findIndexOfCity(cities.get(i+1))];
            }


        }

            sum+=romania.getPathWeight()[romania.findIndexOfCity(origin)][romania.findIndexOfCity(cities.get(count))];

        for (int i=cities.size()-1 ; i>-1 ; i--)

        {
            System.out.print(cities.get(i));

            if (i!=0)
            {
                System.out.print( " ---> ");
            }
        }


        System.out.println(sum);




    }


    private static boolean stopSearching(ArrayList<String> visited , String des)
    {
//        String destination="Fagaras";
        String destination=des;

        if (visited.isEmpty())
        {
            return false;
        }

        for (int i=0 ; i<visited.size() ; i++)
        {
            if (visited.get(i).equals(destination))
            {
                return true;
            }
        }

        return false;
    }

    private static int indexOfCityWithShortestDistence(int[] shortest , ArrayList<String> visited)
    {
        int min=shortest[0];
        int minIndex=0;
        for (int i=0 ; i<20 ; i++)
        {
            if (shortest[i]<min && visited.indexOf(romania.getCitys()[i])==-1)
            {
                min=shortest[i];
                minIndex=i ;
            }
        }

        return minIndex;
    }
}
