//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static class  batsman{
        public String name;
        public int runs;
        public int ballsFaced;
        public String out;
        public double strikeRate;

        public batsman (String name, int runs, int ballsFaced, String out, double strikeRate){
            this.name = name;
            this.runs = runs;
            this.ballsFaced = ballsFaced;
            this.out = out;
            this.strikeRate = strikeRate;
        }

        public batsman (){
            this.name = "";
            this.runs = 0;
            this.ballsFaced = 0;
            this.out = "Not played yet";
            this.strikeRate = 0;
        }

        public void setBallsFaced(int ballsFaced) {
            this.ballsFaced = ballsFaced;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setOut(String out) {
            this.out = out;
        }

        public void setRuns(int runs) {
            this.runs = runs;
        }

        public int getBallsFaced() {
            return ballsFaced;
        }

        public String isOut() {
            return out;
        }

        public int getRuns() {
            return runs;
        }

        public String getName() {
            return name;
        }

        public double getStrikeRate() {
            return strikeRate;
        }

        public void setStrikeRate(double strikeRate) {
            this.strikeRate = strikeRate;
        }
    }
    public static class team{
        public batsman [] batsmen;
        public int totalRuns;
        public int wicketsFallen;
        public double overs;

        public team() {
            this.totalRuns = 0;
            this.wicketsFallen = 0;
            this.overs = 0.0;
            this.batsmen = new batsman[11];
            for (int i = 0; i < 11; i++) {
                this.batsmen[i] = new batsman("Batsman ", 0, 0,"not played yet",0);
            }
        }

        public team(int totalRuns, int wicketsFallen, double overs, batsman[] batsmen) {
            this.totalRuns = totalRuns;
            this.wicketsFallen = wicketsFallen;
            this.overs = overs;
            this.batsmen = batsmen;
        }

        public void setTotalRuns(int totalRuns){
            this.totalRuns = totalRuns;
        }

        public void setWicketsFallen(int wicketsFallen) {
            this.wicketsFallen = wicketsFallen;
        }

        public void setOvers(double overs) {
            this.overs = overs;
        }

        public double getOvers() {
            return overs;
        }

        public int getTotalRuns() {
            return totalRuns;
        }

        public int getWicketsFallen() {
            return wicketsFallen;
        }


    }
    public static void main(String[] args) {
        batsman[] batsmenOfPak = new batsman[11];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 11; i++) {
            System.out.println("Enter name of Player no."+i+" of Pakistan Team:");
            String namePlayer = scanner.nextLine();
            batsmenOfPak[i] = new batsman(namePlayer,0,0,"Not played yet",0);
        }

        batsman [] batsmenOfInd = new batsman[11];
        for (int i = 0; i < 11; i++) {
            System.out.println("Enter name of Player no."+i+" of Indian Team:");
            String namePlayer = scanner.nextLine();
            batsmenOfInd[i] = new batsman(namePlayer,0,0,"Not played yet",0);
        }

        Random random = new Random();
        int toss = random.nextInt(2);
        int totalRunsPak = 0;
        int totalRunsInd = 0;
        int fallenWicketsPak = 0;
        int fallenWicketsInd = 0;
        int oversPak = 0;
        int oversInd = 0;
        if(toss == 0) {         //Batting turn if Pakistan wins the toss
            int overNo = 0;
            int ballNo = 0;
            int score = 0;
            int a = 0;
            System.out.println("Team Pakistan Won the toss!...They decided for batting");
            while(overNo <= 20 || a < 11) {

                while(batsmenOfPak[a].isOut() != "out"){

                    score = random.nextInt(12)-1;
                    batsmenOfPak[a].setRuns(batsmenOfPak[a].getRuns()+score);
                    batsmenOfPak[a].setBallsFaced(batsmenOfPak[a].getBallsFaced()+1);
                    ballNo++;
                    if(ballNo == 6){
                        overNo++;
                        ballNo = 0;
                    }
                    totalRunsPak = totalRunsPak + score;
                    if(score == -1){
                        fallenWicketsPak++;
                        batsmenOfPak[a].setRuns(batsmenOfPak[a].getRuns()+1);
                        batsmenOfPak[a].setOut("out");
                        break;
                    } else if (overNo == 20) {
                        break;
                    }
                    else{

                    }

                }
                batsmenOfPak[a].strikeRate = (batsmenOfPak[a].runs/batsmenOfPak[a].ballsFaced*100);
                a++;
                oversPak = overNo;
                if(a == 11){
                    break;
                }

            }
        }
        else{                   //Batting turn if india wons the toss
            int overNo = 0;
            int ballNo = 0;
            int score = 0;
            int a = 0;
            System.out.println("Team India Won the toss!...They decided for batting");
            while(overNo <= 20 || a < 11) {

                while(batsmenOfInd[a].isOut()!="out"){

                    score = random.nextInt(12)-1;
                    batsmenOfInd[a].setRuns(batsmenOfInd[a].getRuns()+score);
                    batsmenOfInd[a].setBallsFaced(batsmenOfInd[a].getBallsFaced()+1);
                    ballNo++;
                    if(ballNo == 6){
                        overNo++;
                        ballNo = 0;
                    }
                    totalRunsInd = totalRunsInd + score;
                    if(score == -1){
                        batsmenOfInd[a].setRuns(batsmenOfInd[a].getRuns()+1);
                        batsmenOfInd[a].setOut("out");
                        fallenWicketsInd++;
                        break;
                    } else if (overNo == 20) {
                        break;
                    }
                    else{

                    }

                }
                batsmenOfInd[a].strikeRate = (batsmenOfInd[a].runs/batsmenOfInd[a].ballsFaced*100);
                a++;
                oversInd = overNo;
                if(a == 11){
                    break;
                }


            }
        }

        //Batting turn of the team who has loss the toss
        if(toss == 0) {
            int overNo = 0;
            int ballNo = 0;
            int score = 0;
            int a = 0;
            System.out.println("Team India's turn for batting");
            while(overNo <=  20 || a < 11) {

                while(batsmenOfInd[a].isOut()!="out"){

                    score = random.nextInt(12)-1;
                    batsmenOfInd[a].setRuns(batsmenOfInd[a].getRuns()+score);
                    batsmenOfInd[a].setBallsFaced(batsmenOfInd[a].getBallsFaced()+1);
                    ballNo++;
                    if(ballNo == 6){
                        overNo++;
                        ballNo = 0;
                    }
                    totalRunsInd = totalRunsInd + score;
                    if(score == -1){
                        batsmenOfInd[a].setRuns(batsmenOfInd[a].getRuns()+1);
                        batsmenOfInd[a].setOut("out");
                        fallenWicketsInd++;
                        break;
                    } else if (overNo == 20) {
                        break;
                    }
                    else{

                    }

                }
                batsmenOfInd[a].strikeRate = (batsmenOfInd[a].runs/batsmenOfInd[a].ballsFaced*100);
                a++;
                oversInd = overNo;
                if(a == 11){
                    break;
                }

            }
        }
        else{                   //Batting turn if india wons the toss
            int overNo = 0;
            int ballNo = 0;
            int score = 0;
            int a = 0;
            System.out.println("Team Pak's turn for batting");
            while(overNo <= 20 || a < 11) {

                while(batsmenOfPak[a].isOut()!="out"){

                    score = random.nextInt(12)-1;
                    batsmenOfPak[a].setRuns(batsmenOfPak[a].getRuns()+score);
                    batsmenOfPak[a].setBallsFaced(batsmenOfPak[a].getBallsFaced()+1);
                    ballNo++;
                    if(ballNo == 6){
                        overNo++;
                        ballNo = 0;
                    }
                    totalRunsPak = totalRunsPak + score;
                    if(score == -1){
                        batsmenOfPak[a].setRuns(batsmenOfPak[a].getRuns()+1);
                        batsmenOfPak[a].setOut("out");
                        fallenWicketsPak++;
                        break;
                    } else if (overNo == 20) {
                        break;
                    }
                    else{

                    }

                }
                batsmenOfPak[a].strikeRate = (batsmenOfPak[a].runs/batsmenOfPak[a].ballsFaced*100);
                a++;
                oversPak = overNo;
                if(a == 11){
                    break;
                }

            }
        }

        team pakistanTeam = new team(totalRunsPak,fallenWicketsPak,oversPak,batsmenOfPak);
        team indianTeam = new team(totalRunsInd,fallenWicketsInd,oversInd,batsmenOfInd);

        if(pakistanTeam.totalRuns > indianTeam.totalRuns){
            System.out.println("Pakistan wins the match with "+pakistanTeam.totalRuns+" runs. congratulations");
        }
        else{
            System.out.println("India wins the match with "+indianTeam.totalRuns+" runs. congratulations");
        }
        //Team Information
        System.out.println("-------------------PAKISTAN TEAM INFORMATION---------------------------------");
        System.out.println("Total Runs of Pakistan Team : " + pakistanTeam.totalRuns);
        System.out.println("Total no of overs : " + pakistanTeam.overs);
        System.out.println("No of wickets fallen : " + pakistanTeam.wicketsFallen);
        System.out.println("--------------------INDIAN TEAM INFORMATION------------------------------");
        System.out.println("Total Runs of Indian Team : " + indianTeam.totalRuns);
        System.out.println("Total no of overs : " + indianTeam.overs);
        System.out.println("No of wickets fallen : " + indianTeam.wicketsFallen);
        //  SCORE BOARD
        for (int i = 0; i < 11; i++) {
            System.out.println("-------------------------------INFORMATION OF PAKISTAN TEAMS PLAYER NO."+i+" --------------------------");
            System.out.println("Name of player : "+batsmenOfPak[i].name);
            System.out.println("No of runs of that player : "+batsmenOfPak[i].getRuns());
            System.out.println("Balls faced by that player : "+batsmenOfPak[i].ballsFaced);
            System.out.println("Out status : "+batsmenOfPak[i].isOut());
            System.out.println("Strike rate of that player : "+batsmenOfPak[i].strikeRate);
        }

        for (int i = 0; i < 11; i++) {
            System.out.println("-------------------------------INFORMATION OF INDIAN TEAMS PLAYER NO."+i+" --------------------------");
            System.out.println("Name of player : "+batsmenOfInd[i].name);
            System.out.println("No of runs of that player : "+batsmenOfInd[i].getRuns());
            System.out.println("Balls faced by that player : "+batsmenOfInd[i].ballsFaced);
            System.out.println("Out status : "+batsmenOfInd[i].isOut());
            System.out.println("Strike rate of that player : "+batsmenOfInd[i].strikeRate);
        }

        
        scanner.close();
    }
}