# Worldgaurd Eliminate 
**Worldgaurd Eliminate** is a Spigot plugin that automatically despawns monsters when they enter a predefined WorldGuard region in a specific world. This is particularly useful for keeping certain areas (such as spawn regions) free from hostile mobs.

## Features
- Automatically removes monsters from a designated WorldGuard region.
- Fully configurable via `config.yml`.

## Requirements
- **Spigot** (or a compatible server, such as PaperSpigot).
- **WorldGuard** and **WorldEdit** plugins for region management.

## Installation
1. Download the latest version of the plugin.
2. Place the plugin `.jar` file into your server's `plugins` folder.
3. Restart your server to generate the default configuration files.

## Configuration
After the plugin is installed, you can configure the plugin by editing the `config.yml` file located in the `plugins/WorldGuardEliminate` folder.

```yaml
## World is the world name which contains the region you would like to despawn mobs in.
World: "world"
Region: "spawn"
```
- World: The name of the world where the region is located.
- Region: The WorldGuard region where monsters will be automatically removed.