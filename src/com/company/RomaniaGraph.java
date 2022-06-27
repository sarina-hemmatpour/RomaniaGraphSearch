package com.company;

public class RomaniaGraph
{
    private int[][] map=new int[20][20];
    private int[][] pathWeight=new int[20][20];
    private String[] citys=new String[20];

    public String[] getCitys() {
        return citys;
    }

    public void setCitys(String[] citys) {
        this.citys = citys;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int[][] getPathWeight() {
        return pathWeight;
    }

    public void setPathWeight(int[][] pathWeight) {
        this.pathWeight = pathWeight;
    }

    public RomaniaGraph() {
        fillMapArray();
        fillPathWeightArray();
        fillCitys();
    }

    private void fillMapArray()
    {
        //existed path
        map[0][1]=1;
        map[1][0]=map[1][2]=1;
        map[2][1]=map[2][3]=map[2][6]=1;
        map[3][2]=map[3][4]=1;
        map[4][3]=map[4][5]=1;
        map[5][4]=1;
        map[6][2]=map[6][7]=map[6][8]=map[6][9]=1;
        map[7][6]=1;
        map[8][6]=map[8][12]=1;
        map[9][6]=map[9][10]=map[9][11]=1;
        map[10][9]=map[10][11]=map[10][13]=1;
        map[11][9]=map[11][10]=map[11][12]=1;
        map[12][8]=map[12][11]=map[12][17]=map[12][19]=1;
        map[13][10]=map[13][14]=1;
        map[14][13]=map[14][15]=1;
        map[15][14]=map[15][16]=1;
        map[16][15]=map[16][17]=1;
        map[17][16]=map[17][18]=map[17][12]=1;
        map[18][17]=map[18][19]=1;
        map[19][12]=map[19][18]=1;

        //non existed path
        for (int i=0 ; i<20 ; i++)
        {
            for (int j=0 ; j<20 ; j++)
            {
                if (map[i][j]!=1)
                {
                    map[i][j]=0;
                }
            }
        }


    }



    private void fillPathWeightArray()
    {

        for (int i=0 ; i<20 ; i++)
        {
            for (int j=0 ; j<20 ; j++)
            {
                pathWeight[i][j]=-1;
            }
        }



        pathWeight[0][1]=86;

        pathWeight[1][0]=86;
        pathWeight[1][2]=98;

        pathWeight[2][1]=98;
        pathWeight[2][3]=142;
        pathWeight[2][6]=85;

        pathWeight[3][2]=142;
        pathWeight[3][4]=92;

        pathWeight[4][3]=92;
        pathWeight[4][5]=87;

        pathWeight[5][4]=87;

        pathWeight[6][2]=85;
        pathWeight[6][7]=90;
        pathWeight[6][8]=211;
        pathWeight[6][9]=101;

        pathWeight[7][6]=90;

        pathWeight[8][6]=211;
        pathWeight[8][12]=99;

        pathWeight[9][6]=101;
        pathWeight[9][10]=138;
        pathWeight[9][11]=97;

        pathWeight[10][9]=138;
        pathWeight[10][11]=146;
        pathWeight[10][13]=120;

        pathWeight[11][9]=97;
        pathWeight[11][10]=146;
        pathWeight[11][12]=80;

        pathWeight[12][8]=99;
        pathWeight[12][11]=80;
        pathWeight[12][17]=140;
        pathWeight[12][19]=151;

        pathWeight[13][10]=120;
        pathWeight[13][14]=75;

        pathWeight[14][13]=75;
        pathWeight[14][15]=70;

        pathWeight[15][14]=70;
        pathWeight[15][16]=111;

        pathWeight[16][15]=111;
        pathWeight[16][17]=118;

        pathWeight[17][16]=140;
        pathWeight[17][18]=118;
        pathWeight[17][12]=75;

        pathWeight[18][17]=75;
        pathWeight[18][19]=71;

        pathWeight[19][12]=151;
        pathWeight[19][18]=71;



    }
    private void fillCitys()
    {
        citys[0]="Eforie";
        citys[1]="Hirsova";
        citys[2]="Urziceni";
        citys[3]="Vaslui";
        citys[4]="lasi";
        citys[5]="Neamt";
        citys[6]="Bucharest";
        citys[7]="Giurgiu";
        citys[8]="Fagaras";
        citys[9]="Pitesti";
        citys[10]="Craiova";
        citys[11]="Rimncu Vilcea";
        citys[12]="Sibiu";
        citys[13]="Dobreta";
        citys[14]="Mehadia";
        citys[15]="Lugoj";
        citys[16]="Timisoara";
        citys[17]="Arad";
        citys[18]="Zerind";
        citys[19]="Oradea";
    }

    protected int findIndexOfCity(String name)
    {
        for (int i=0 ; i<20 ; i++)
        {
            if (citys[i].equals(name))
            {
                return i;
            }
        }
        return -1;
    }

}

