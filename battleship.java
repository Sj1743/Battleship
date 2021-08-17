import java.util.*;

public class battleship{

    static Scanner scanner = new Scanner(System.in);
    static char field[][] = new char[10][10];
    static char discovered[][] = new char[10][10];
    static int round = 0;
    static int stealth = 300;
    static int points = 0;
    static int lastRoundPoints = 0;
    static int lastRow = 0;
    static int lastColumn = 0;
    public static void main(String args[]){

        displayIntro();
        assignWater();
        assignShips();
        assignMines();
        
        while(allShipsHit() == false || stealth > 0){

            round++;
            System.out.println("\n\nRound: " + round);
            System.out.println("Stealth: " + stealth + "\n");

            if(round % 4 == 0){
                hints();
            }

            prompt();
            int row = getRow();
            int column = getColumn();

            if(discovered[column][row] == '~' || discovered[column][row] == '*' || discovered[column][row] == 'O'){
                System.err.println("This spot was already hit! Try again.");
                round--;
                continue;
            }

            discovered[column][row] = field[column][row];
            printDiscovery();

            char hit = discovered[column][row];
            switch(hit){
                case '~' : hitWater(); 
                    break;
                case '*' : hitMine();
                    break;
                case 'O' : hitEnemy();
                    break;
                default: System.err.println("Well, that was unexpected.");
            }

            lastRoundPoints = points;
            lastRow = row;
            lastColumn = column;

            if(allShipsHit() == true){
                System.out.println("\nGreat job, mate! We are victorious!");
                break;
            }
        }

        if(stealth <= 0){
            System.err.println("What a shame! Your stealth has dropped to " + stealth);
        }

        System.out.println("This is everything you did on the battlefield today");
        printDiscovery();
        System.out.println("\nSee ya soon, rookie!");
    }

    public static void assignWater(){
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                field[x][y] = '~';
            }
        }
    }

    public static void assignShips(){
        field[0][1] = 'O';
        field[0][2] = 'O';
        field[0][3] = 'O';
        field[1][6] = 'O';
        field[2][3] = 'O';
        field[2][4] = 'O';
        field[2][6] = 'O';
        field[2][8] = 'O';
        field[2][9] = 'O';
        field[3][1] = 'O';
        field[3][6] = 'O';
        field[4][1] = 'O';
        field[5][1] = 'O';
        field[6][3] = 'O';
        field[6][4] = 'O';
        field[6][5] = 'O';
        field[6][6] = 'O';
        field[7][9] = 'O';
        field[8][0] = 'O';
        field[8][1] = 'O';
        field[8][9] = 'O';
        field[9][9] = 'O';
    }

    public static void assignMines(){
        field[1][3] = '*';
        field[2][1] = '*';
        field[2][2] = '*';
        field[2][5] = '*';
        field[2][7] = '*';
        field[3][9] = '*';
        field[4][6] = '*';
        field[5][5] = '*';
        field[6][7] = '*';
        field[7][3] = '*';
        field[8][6] = '*';
        field[9][0] = '*';
    }

    public static void printField(){
        System.out.print("\n    ");
        for(int a = 0; a < 10; a++){
            System.out.print((a+1) + " ");
        }
        System.out.print("\n\n");
        for(int x = 0; x < 10; x++){
            char alph = (char)(x + 65);
            System.out.print(alph + "   ");
            for(int y = 0; y < 10; y++){
                System.out.print(field[x][y] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void printDiscovery(){
        System.out.print("\n    ");
        for(int a = 0; a < 10; a++){
            System.out.print((a+1) + " ");
        }
        System.out.print("\n\n");
        for(int x = 0; x < 10; x++){
            char alph = (char)(x + 65);
            System.out.print(alph + "   ");
            for(int y = 0; y < 10; y++){
                System.out.print(discovered[x][y] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static boolean allShipsHit(){
        if(discovered[0][1] == 'O' && discovered[0][2] == 'O' && discovered[0][3] == 'O' && discovered[1][6] == 'O' 
        && discovered[2][3] == 'O' &&  discovered[2][4] == 'O' && discovered[2][6] == 'O' && discovered[2][8] == 'O'
        && discovered[2][9] == 'O' && discovered[3][1] == 'O' && discovered[3][6] == 'O' && discovered[4][1] == 'O'
        && discovered[5][1] == 'O' && discovered[6][3] == 'O' && discovered[6][4] == 'O' && discovered[6][5] == 'O'
        && discovered[6][6] == 'O' && discovered[7][9] == 'O' && discovered[8][0] == 'O' && discovered[8][1] == 'O'
        && discovered[8][9] == 'O' && discovered[9][9] == 'O'){
            return true;
        }else{
            return false;
        }
    }

    public static void beta(){
        discovered[0][1] = 'O';
        discovered[0][2] = 'O'; 
        discovered[0][3] = 'O';
        discovered[1][6] = 'O';
        discovered[2][3] = 'O';
        discovered[2][4] = 'O';
        discovered[2][6] = 'O';
        discovered[2][8] = 'O';
        discovered[2][9] = 'O';
        discovered[3][1] = 'O';
        discovered[3][6] = 'O';
        discovered[4][1] = 'O';
        discovered[5][1] = 'O';
        discovered[6][3] = 'O';
        discovered[6][4] = 'O';
        discovered[6][5] = 'O';
        discovered[6][6] = 'O';
        discovered[7][9] = 'O';
        discovered[8][0] = 'O';
        discovered[8][1] = 'O';
        discovered[8][9] = 'O';
        discovered[9][9] = 'O';
    }

    public static int getRow(){
        int rowTemp = 0;
        int row = 0;
        while(rowTemp < 1 || rowTemp > 10){
            System.out.print("Enter row (1 to 10): ");
            rowTemp = scanner.nextInt();
            row = rowTemp - 1;
        }
        return row;
    }

    public static int getColumn(){
        char columnTemp = 'K';
        int column = 0;
        while(columnTemp < 'A' || columnTemp > 'J' || columnTemp == 'Q' || columnTemp == 'S'){
            System.out.print("Enter column (A to J): ");
            char columnAlph = scanner.next().charAt(0);
            columnTemp = Character.toUpperCase(columnAlph);
            if(columnTemp == 'Q'){
                System.out.print("Are you sure you want to quit? (y/n) ");
                char quit = scanner.next().charAt(0);
                if(quit == 'y' || quit == 'Y'){
                    System.err.println("\nWell played! Here's your final battlefield");
                    printDiscovery();
                    System.err.println("\nLater, mate!");
                    System.exit(0);
                }else{
                    System.out.println("Continuing");
                    System.out.print("Enter column (A to J): ");
                    columnAlph = scanner.next().charAt(0);
                    columnTemp = Character.toUpperCase(columnAlph);
                }
            }
            column = (columnTemp - 65);
        }
        return column;
    }

    public static void displayIntro(){
        System.out.println("\n**BATTLESHIP**\nWelcome to the Battlefield\n");
        System.out.println("There are a 100 spots on the battlefield, with 8 enemy ships and 12 mines. There are 3 ships that are 2 units long, 4 ships that are 3 units long, and 1 ship that is 4 units long.");
        System.out.println("Your objective is to hit all the ships, with minimal damage to your stealth points. If your stealth drops to zero, you lose!"); 
        System.out.println("You can quit anytime by entering 'Q' as the column. Every fourth round, you may opt for a hint or continue without.");
        System.out.println("To being with, you have 300 stealth. For each mine you hit, you lose 80 stealth. Upto 40 stealth can be deducted for wasting artillery on water.");
        System.out.println("Each time you hit an enemy ship, you gain 90 stealth. Two in a row, and you get 120. Hat trick calls for 160. Poker or anything greater awards you with 200 stealth.");
        System.out.println("\n'~' : water\n'O' : ship\n'*' : mine");
    }

    public static void prompt(){

        int random = (int)(Math.random() * 7);
        switch(random){
            case 0: System.out.println("Aim your cannons!"); break;
            case 1: System.out.println("Zero in on the hostile!"); break;
            case 2: System.out.println("Unleash the artillery!"); break;
            case 3: System.out.println("The powder is in, now strike a match!"); break;
            case 4: System.out.println("Fire away!"); break;
            case 5: System.out.println("Is that an enemy ship you spy?!"); break;
            case 6: System.out.println("Think up your war cries!"); break;
            default: System.out.println("What are you waiting for?! Enter row and column."); break;
        }
    }

    public static int hitWater(){
        System.out.println("YOU HIT WATER ~");
        int random = (int)(Math.random() * 7);
        switch(random){
            case 0: System.out.println("Fie, Fie!"); break;
            case 1: System.out.println("What a waste of artillery!"); break;
            case 2: System.out.println("Better luck next time."); break;
            case 3: System.out.println("Terrible aim."); break;
            case 4: System.out.println("You can do better than that!"); break;
            case 5: System.out.println("Is this how you plan on destroying you enemies?!"); break;
            case 6: System.out.println("Pathetic. It's just water."); break;
            default: System.out.println("Really? Try again.");
        }
        int r = (int)(Math.random() * 6);
        switch(r){
            case 1: points = 0; break;
            case 2: points = -10; break;
            case 3: points = -20; break;
            case 4: points = -30; break;
            case 5: points = -40; break;
            default: points = -30;
        }
        stealth += points; 
        System.out.println("Damage: " + points + " stealth.");
        return points;
    }

    public static int hitMine(){
        System.out.println("YOU HIT A MINE *");
        int random = (int)(Math.random() * 7);
        switch(random){
            case 0: System.out.println("Thou stickest a dagger in me!"); break;
            case 1: System.out.println("Heavy damage!"); break;
            case 2: System.out.println("Pray you do better than that."); break;
            case 3: System.out.println("This could not get any worse!"); break;
            case 4: System.out.println("Avoid mines, it hurts."); break;
            case 5: System.out.println("This is self-destruction!"); break;
            case 6: System.out.println("Onboard damage and crew injuries!"); break;
            default: System.out.println("That was bad. Try again");
        }
        points = -80;
        stealth += points; 
        System.out.println("Damage: " + points + " stealth.");
        return points;
    }

    public static int hitEnemy(){
        System.out.println("YOU HIT AN ENEMY O");
        int random = (int)(Math.random() * 7);
        switch(random){
            case 0: System.out.println("That's what I'm talking about!"); break;
            case 1: System.out.println("Vamos! Muy bien!"); break;
            case 2: System.out.println("Knew you could do it!"); break;
            case 3: System.out.println("Giving them enemies a tough time, eh?"); break;
            case 4: System.out.println("My money on you, regret nothing."); break;
            case 5: System.out.println("Way to go! Keep it up."); break;
            case 6: System.out.println("A true viking descendant!"); break;
            default: System.out.println("Very well done. Keep going.");
        }
        if(lastRoundPoints == 90){
            points = 120;
            System.out.println("Two in a row! Fascinating. You earned 120 stealth.");
        }else if(lastRoundPoints == 120){
            points = 160;
            System.out.println("Hat trick! Brilliant! 160 stealth awarded!");
        }else if(lastRoundPoints == 160){
            points = 200;
            System.out.println("Poker! Impossible! This gives you 200 stealth!");
        }else if(lastRoundPoints >= 160){
            points = 200;
            System.out.println("This...is incredibly hard to believe. 200 stealth to Gryffindor!");
        }else{
            points = 90;
            System.out.println("Bravo! Stealth increased by 90");
        }
        stealth += points; 
        return points;
    }

    public static int hints(){
        System.out.print("A hint is available! Do you wish to use it? Note that using applying hints will cost you stealth! (y/n): ");
        char wish = scanner.next().charAt(0);
        if(wish == 'n' || wish == 'N'){
            System.out.println("No hint required for this tough guy! Let's move on\n");
            points = 0;
            return points;
        }else if(wish == 'y' || wish == 'Y'){
            int r = lastRow;
            int c = lastColumn;
            char opt = ' ';
            System.out.println("\nSo you want a hint. There are two things that can be done:");
            System.out.println("a. Reveal what is around your last hit - this will cost you 80 stealth.");
            System.out.println("b. Reveal a ship - this will cost you 40 stealth");
            if(r == 0 || r == 9 || c == 0 || c == 9){
                System.err.println("\nBut soft! Your last hit was out of bounds! So it's surroundings cannot be revealed.");
                System.err.println("This means a ship will be revealed (option b) and 40 stealth will be deducted.");
                opt = 'b';
            }else{
                System.out.print("\nNow then, which ever will it be? (a/b): ");
                opt = scanner.next().charAt(0);
            }
            if(opt == 'a' || opt == 'A'){
                System.out.println("\nThe 8 spots around your last hit have been revealed for 80 stealth!");
                points = -80;
                discovered[c-1][r-1] = field[c-1][r-1];
                discovered[c-1][r] = field[c-1][r];
                discovered[c-1][r+1] = field[c-1][r+1];
                discovered[c][r-1] = field[c][r-1];
                discovered[c][r+1] = field[c][r+1];
                discovered[c+1][r-1] = field[c+1][r-1];
                discovered[c+1][r] = field[c+1][r];
                discovered[c+1][r+1] = field[c+1][r+1];
            }else if(opt == 'b' || opt == 'B'){
                System.out.println("\nA ship has been revealed for 40 stealth!");
                points = -40;
                revealShip();
            }
        }
        printDiscovery();
        stealth += points; 
        return points;
    }

    public static void revealShip(){
        boolean revealed = false;
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                if(field[x][y] == 'O'){
                    if(discovered[x][y] == 'O'){
                        continue;
                    }else{
                        discovered[x][y] = 'O';
                        revealed = true;
                        break;
                    }
                }
            }
            if(revealed == true)
                break;
        }
    }
}