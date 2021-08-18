# Battleship
## A single player variation of the Battleship game with a few twists

To execute, download the compiled .class file and run on cmd or any application with a jre

## Add fields!

##### You can contribute to Battleship by creating fields that can be included in the game

**How do I create a field, you ask**

1. Draw a 10x10 grid.

1. Plot ships, mines, & water in the grid squares. 
    Use the following symbols:
    ```
    O - ship
    * - mine
    ~ - water
    ```
    However, there are a few things to keep in mind while strategically plotting the elements:-
  - There must 8 enemy ships that occupy 22 grid squares in total. The distribution of ships with respect to their lengths are:
      i. 3 ships that are 2 units long
      ii. 4 ships that are 3 units long
      iii. 1 ship that is 4 units long
  - There must be 12 mines. A tip to place them strategically is to place a few around ships so that the user is tempted to strike there, only to hit a mine, and scattered few     randomly in the field. Have a look at my pre-existing fields for ideas.
  - After you have placed the 8 ships and 12 mines, the rest of the grid squares will be water. These will be 66 in total.
 
 3. Now, assign the ships and mines (assigning water is not required) to their respective indices on the field. The field is actually a 2-dimensional character array. 
    The general syntax to assign in a 2D array is:
   ```
    array_name[column][row] = ' '; //assignment within single quotes since it is a char array :-  'O' || '*'
   ```
   So in order to assign say a ship in column 1 and row 4, the syntax will be as follows:
   ```
    field[0][5] = 'O';
   ```
   **Note** that arrays start at index 0 so ensure you assign accordingly.  
   Feel free to look up my src to further clarify this understanding.
   
4. Issue a pull request for a .txt file with the above assingments, 34 in all. Also include the grid as an image.

That's it! If all the above criteria are met, this field will be included as a variation in Battleship!
