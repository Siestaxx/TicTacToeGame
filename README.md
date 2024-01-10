# TicTacToeGame
Simple TicTacToe with interface
## Design of Our Program:
   The first part is layout: create units and place them in the proper places.The second part is the interactive part: Depending on where the event comes from, the program changes text on the button. The third part is the judgement: All the possibilities are listed. If any condition fits, declare the result of the game.
   First, we import the things that support us to create the game, java gui, includes import javax.swing.*; import java.awt.*; import java.awt.event.ActionEvent;import java.awt.event.ActionListener;
   Next, in the program of TTTGame, we set several private variables, including what we needed in the program and the panel that display the game. 
   We set the layout to be null and the buttons and their dimensions including the 9 bottons that placed on the grids that we can put X and Os on, and the new game, score indicator, and who should play next. 
   Then, we place the buttons into the correct positions.
   Then, when the game has a winner but the players still put X or Os on the empty grids, we make a warning that they should press the new game button. And then, we check, if one chess has already put on a grid, then we can not put on this grid anymore, also, we check that if O is first, then the next turn should be X and vice versa. And when starting a new game, everything renew.
   After that, we check the winner status. That is when the three grids on a row, column or the diagonal has the same chess, then that person is winning. 
   In the main, we set the outer frame of the TTTGame.
