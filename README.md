# Project Information

## About the Game
Our project is a resource-management game based on a farm theme. The user can create an account that saves their farm information so they can come back to their farm whenever they want. The user carries the responsibility of a farmer, as they can buy and sell goods that they yield from their crops and animals. When the user chooses to progress to the next day, there's a chance of a random event happening that can either benefit or cause drawbacks for the user. Once the user reaches certain milestones for their farm, they win the game!

## About the Design/Scope
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

Most of the use cases have their own UI screens to separate their functionalities. Each UI screen calls upon their corresponding controller to execute their functionality. 

<p align="center">
  <img src="https://user-images.githubusercontent.com/109601140/206353961-03d16f38-31b8-4a82-9fc3-8c281433a730.png">
</p>

Each use case has a controller in the Interface Adapters layer and a use case interactor in the Use Case layer. For the controllers, the "winning/losing condition" use case and "random events" use case are called under the "go to next day" use case, which is why they don't need controllers for those use cases. Each controller interprets the user input collected from the UI and calls upon their corresponding use case interactor to carry out the functions of the use case using various methods. There are 'global use case interactors' that are in the "use_case_interactors" package called PlotManager and InventoryManager that each of the use case interactors use to fetch information from the Entities layer to use in their functions. 

<p align="center">
  <img src="https://user-images.githubusercontent.com/109601140/206353649-aeabea17-5106-4a99-b67c-46aa59c52d59.png">
  <img src="https://user-images.githubusercontent.com/109601140/206353681-bcb40d7b-165e-429c-9adb-15d87af3c533.png">
  <img src="https://user-images.githubusercontent.com/109601140/206353714-7b37f388-6a9f-4865-aad0-e51d4b530418.png">
</p>

The user's information like their plots and inventory are in the Entities layer, along with the information/data bundles of the different items that you can buy from the shop. The items that you can buy from the shop are all Products, as they all extend from the Products class. Each product has their own attributes with their own unique values. Some products implement the "Yieldable" interface. These special products are products that can be obtained by being harvested/extracted from other products. For example, milk is a yieldable product from a cow, but the cow is not a yieldable product, it is just a product. With these definitions, only yieldable products can be sold. 

<p align="center">
  <img src="https://user-images.githubusercontent.com/109601140/206354083-569d860c-3c55-4dde-8bf6-4c7b19cd39e0.png">
</p>

In terms of tests, our tests cover a wide variety of cases for each use case interactor and entity:

<p align="center">
  <img src="https://user-images.githubusercontent.com/109601140/206363900-0c8785ee-8f02-45ff-9141-7181fa1f47e4.png" width="350" height="300" />
</p>

The reason why that our program is static-heavy in the Entities layer is because each use case interactor needs to use the global use case interactors, since the global use case interactors are the gateways to the Entities layer. For example, the "Check Progress" use case needs PlotManager and InventoryManager to be static so it can call its methods that fetch the uer's inventory and plot information.

## How to Start The Game
Run the Ranchville.java file.

## How to Play/Functionality
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

The main screen is where you can carry out your responsibilities as a farmer and do the things you need to do for the day. You can save your game by pressing "Save Game" so you can come back to it another day. You can share you farm by pressing "Share" and check the leaderboard of farms by pressing "Check Leaderboard". You can check the progress of your farm by pressing "Check Progress". You can go to the market by pressing "Go to Shop" to buy and sell goods or buy more plots. You can manage the plots of your farm by pressing "Go to farm", where you can harvest your crops, and extract yields from your animals. 

When you go to your farm, you can place a product in one of your empty plots to start growing that product. You can do this by typing the desired product you want to place in the "Enter Product:" textbox. Then, type the plot id (of the plot you want to place it in) in the "Enter Plot Id:" textbox. After entering the product and plot id, press "place" and it will the place the desired product in the desired plot. If one of your plots is ready to be yielded, you would use harvest on a plot that has a crop-type product, and extract on a plot that has an animal-type product. To harvest/extract a plot that is ready to be yielded, enter the plot id of the particular plot that is ready in the corresponding "Enter Plot ID:" textbox and press "harvest" or "extract" depending on the product type. Once you're done managing your farm, click "DONE" to go back to the main menu.

<p align="center">
  <img src="https://user-images.githubusercontent.com/109601140/206355618-30789bcf-ba1a-4918-ad23-6db62b3ed239.png" width="350" height="300" />
</p>

When to go to the shop, you can buy products or plots, or sell yieldable products. To view what you can buy and to see the prices of the things you can buy, press "Display Price". With this information, enter the exact name of the product you want to sell/buy and the amount (keep in mind, only yieldable products can be sold, which are products that can be harvested/extracted like milk or eggs, not cows or chickens). Before buying, make sure you have enough money to purchase the things you want. Before selling, make sure you have enough of the product that you want to sell. After completing your shopping, press "DONE" to go back to main menu.

<p align="center">
  <img src="https://user-images.githubusercontent.com/109601140/206356379-866a5763-1a09-4a01-a39a-31aafc3d0a68.png" width="350" height="300" />
</p>

To check your progress, press "Display Progress". A messagebox will pop up and show you the contents of your inventory, information about your plots and your money. Once you are finished with checking your progress, press "Go to Main Menu" to go back to the main menu.

<p align="center">
  <img src="https://user-images.githubusercontent.com/109601140/206357730-f62ee059-81e7-47d0-b381-8ffb6fc55c90.png" width="350" height="300" />
  <img src="https://user-images.githubusercontent.com/109601140/206357793-87de393f-06b7-4634-b61b-f7d0f53340cd.png">
</p>

To check the leaderboard, press "Display Leaderboard". A messagebox will pop up and show your ranking with other players (on your local computer) in terms of money. Once you are done checking the leaderboard, press "Back" to go back to the main menu.

<p align="center">
  <img src="https://user-images.githubusercontent.com/109601140/206358394-ce2e7ddf-bc1f-4b95-8a91-0d4402877d11.png" width="350" height="300" />
  <img src="https://user-images.githubusercontent.com/109601140/206358431-333caffd-3249-4108-85e8-1722eb72a6ee.png">
</p>

To share you farm, the share screen will display pictures for all the products in your plots. Using this display, screenshot the screen and save the image to show your friends later!

<p align="center">
  <img src="https://user-images.githubusercontent.com/109601140/206359352-e38101e5-8793-41b9-b0e4-901404086929.png" width="350" height="300" />
</p>

Once you've finished your chores for the day, you can progress to the next day by pressing "Next Day". When you go to the next day, there will be a chance that a random event will occur!
