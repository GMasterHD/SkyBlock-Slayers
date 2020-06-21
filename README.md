# SkyBlock Mod (1.0.0)
## Download
To download the mod, click on the top the "releases" button and download the newest version.  
The compiled JAR Files are located under "Assets"

## Changelog
### 1.0.0
- [+] Slayer Drop counter for each type of Slayer
- [+] Kill Counter for each type of Slayer

### 1.0.1
- [+] Added more arguments to sbs command

## Commands

    /sbs toggle
> Toggles the slayer ui

    /sbs reset <slayer>
> Reset a specific slayer

    /sbs <position|pos> <x> <y>
> Set the position of the slayers menu

## External Files
> **Only edit your external files if you know what you are doing!  
If something gets corrupted you have to delete your config and/or your saves file, so be carefull.**

There are two external files:

- config.json  
- saves.json

The saves.json file has information about the players Slayer stats
> For example Slayer Kill Count  

The Slayer Kill Count is located under the specific slayer:

    "name": "Revenant Horror",
    "killCount": 29

If you change the kill count, restart Minecraft and will be updated

You don't have to change your saves file, you can also type the "/sbs" command and set your value!  
> Commands are explaimed at the top.

The config.json file has information about the Slayers that exists SkyBlock
>  For example Slayer Drops and Chat Triggers

    "name": "Revenant Horror",
    "chatTrigger": "Claim your Zombie Slayer XP"
    "Drops": [
        {
            "name": "Scythe Blade",
            "chatTrigger": "Scythe Blade",
            "rarity": "LEGENDARY"
        }
    ]
To add a new Drop a new Slayer copy an alredy existing Slayer and change the values.  

**Warning**  
> To add a new Slayer, you have also to add the Slayer in your Saves File your new Slayer!

To add new Slayer, add this paragraph to your saves.json File and don't forget the comma before your new Slayer and don't write a comma after your Slayer!

saves.json File:  

    {
        "slayerName": "Custom Slayer name (Has to be the same like in cour config.json File",
        "Drops": [
        ]
    }

You don't need to add drops!  
If you got them ingame they will automatically be added to your saves file.
