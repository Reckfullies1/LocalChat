# LocalChat

[![Generic badge](https://img.shields.io/github/license/Reckfullies/LocalChat.svg?label=license&style=popout)](https://github.com/Reckfullies/LocalChat/blob/master/LICENSE.md)
[![Generic badge](https://img.shields.io/github/last-commit/Reckfullies/LocalChat.svg?label=last%20commit&style=popout)](https://github.com/Reckfullies/LocalChat/commits/master)
[![Generic badge](https://img.shields.io/github/downloads/Reckfullies/LocalChat/total.svg?label=github%20downloads&style=popout)](https://github.com/Reckfullies/LocalChat)
[![Generic badge](http://badge.henrya.org/spigotbukkit/downloads?spigot=68073&bukkit=323623&color=red&name=spigot/bukkit%20downloads)](https://dev.bukkit.org/projects/local-chat)

This is a project I created for fun in response to a request on the bukkit forums. Its pretty simple and straightforward.

There are no special commands or permissions other than what is specified in the config file. All commands are created at runtime based on options in the config file, you can add as many of these commands as you want. Just copy-paste a command to add another.

There is also an extra setting which can specify the format of all normal chat messages.

**There are various settings for each command that are as follows:**
 - **Aliases** - A list of strings that specify the chat commands which call this command  **(including the /)**
 - **Permission** - Permission that the player must have to use this command. Leave blank to allow anyone to use the command
 - **Format** - The format of the messages in chat including colors([https://wiki.ess3.net/mc/](https://dev.bukkit.org/linkout?remoteUrl=https%253a%252f%252fwiki.ess3.net%252fmc%252f)), name/message placeholders(<name> and <message> respectively), and any other special formatting
 - **Radius** - Radius **(in blocks)**  away from the sending player that other players will see the message, setting this to 0 or lower will consider the command as global/infinite radius.

If you see anything to improve/add just make a pull request/issue.

![Screenshot](https://i.imgur.com/pPCZAAY.png)
