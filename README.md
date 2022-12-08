# Project Information

## About the Game
Our project is a resource-management game based on a farm theme. The user can create an account that saves their farm information so they can come back to their farm whenever they want. The user carries the responsibility of a farmer, as they can buy and sell goods that they yield from their crops and animals. When the user chooses to progress to the next day, there's a chance of a random event happening that can either benefit or cause drawbacks for the user. Once the user reaches certain milestones for their farm, they win the game!

## How to Play
Press the "Start" button at the title screen and enter your user information in the sign-in screen so the program retrieves your data if you have an exisitng account, or create a new account and farm for you. 

<p align="center">
  <img src="https://user-images.githubusercontent.com/109601140/206333964-baa10d31-accb-48b6-a5ad-1ef7ab31403b.png" width="350" height="300" />
  <img src="https://user-images.githubusercontent.com/109601140/206334050-166dfc59-69b6-43ea-87fc-7cdb40a8a398.png" width="350" height="300" />
</p>

If you have an existing account, click "Load Game" and input your farm name and you will be brought to the main menu and your progress will be restored for you to play. If you are a new user, you must create a new account by clicking "New Game" and inputting what you want the name of your farm to be. After creating your farm, you will be brought to the main screen so you can start your journey!

<p align="center">
  <img src="https://user-images.githubusercontent.com/109601140/206334653-409045e7-f02b-4648-b491-788a45ad5c55.png" width="350" height="300" />
  <img src="https://user-images.githubusercontent.com/109601140/206334891-f30320a7-858e-4135-a351-0c0aa94f2400.png" width="350" height="300" />
</p>

The main screen is where you can carry out your responsibilities as a farmer and do the things you need to do for the day. You can save your game by pressing "Save Game" so you can come back to it another day. You can share you farm by pressing "Share" and check the leaderboard of farms by pressing "Check Leaderboard". You can check the progress of your farm by pressing "Check Progress". You can go to the market by pressing "Go to Shop" to buy and sell goods or buy more plots. You can manage the plots of your farm by pressing "Go to farm". 


Once you've finished your chores for the day, you can progress to the next day by pressing "Next Day".

## About the Design
The program is divided into 9 use cases:
1. Checking progress of farm
2. Sharing your farm
3. Winning/losing condition
4. Random events
5. Raising animals and growing crops
6. Interacting with the market
7. Save state
8. Leaderboard
9. Go to next day

Most of the use cases have their own UI screens to separate their functionalities. Each UI screen calls upon their corresponding controller. Each use case has a controller in the Interface Adapters layer and a use case interactor in the Use Case layer. For the controllers, the "winning/losing condition" use case and "random events" use case are called under the "go to next day" use case, which is why they don't need controllers. Each controller interprets the user input collected from the UI and calls upon their corresponding use case interactor. There are 'global use case interactors' that are in the "use_case_interactors" package called PlotManager and InventoryManager that each of the use case interactors use to fetch information from the Entities layer.  

## About the Scope

## How to Start The Game
Run the FarmGame.java file.
