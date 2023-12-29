# Monty_Hall_Paradox
Monty Hall Paradox in Java


The Monty Hall paradox is a probability puzzle named after the host of the television game show "Let's Make a Deal," Monty Hall. The paradox can be described as follows:

1: A contestant is presented with three doors. Behind one of the doors is a car (the prize), and behind the other two are goats.
2: The contestant selects one door, but that door is not opened immediately.
3: Monty Hall, who knows what is behind each door, opens one of the other two doors, revealing a goat.
4: The contestant is then given the option to either stick with their original choice or switch to the remaining unopened door.
5: The door the contestant selects is then opened, and they win whatever is behind it.


The paradox arises because the optimal strategy is counterintuitive. The contestant should always switch doors after Monty reveals a goat. This strategy increases the probability of winning the car from 1/3 to 2/3.

In my java code:

1: Door Class:

-Each Door object has three boolean attributes: Open (whether the door is open), HasPrize (whether the door has the prize), and ContestantChosen (whether the contestant has chosen that door).

2: PlayingManyGames Class:

-The main class handles user input and runs simulations of the Monty Hall problem based on the user's choice (always switch or never switch).
-It initializes a Game object, prompts the user for their strategy choice, and then runs simulations to calculate the percentage of wins.


3: Game Class:

-SetUpGame: Initializes three doors and randomly selects one to have the grand prize.
-MonteOpenDoor: Simulates Monty opening a door that doesn't have the prize and wasn't chosen by the contestant.
-ContestantChosenDoor: Simulates the contestant choosing a door.
-SwitchDoor: If the contestant chooses to switch, this method simulates the switch by selecting the other unopened door.
-win: Checks if the contestant wins based on their final door choice.


In the simulation, the PlayingManyGames class runs 10,000 iterations for each strategy (switching or not switching), and it calculates and prints the total number of wins and the percentage of wins for the chosen strategy.

The code correctly implements the Monty Hall paradox and demonstrates the increased probability of winning by always switching doors.
