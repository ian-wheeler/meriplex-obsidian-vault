---
created: 2024-06-17T10:13
updated: 2024-06-28T14:20
---
# Dataview

```dataview
TABLE WITHOUT ID
	file.link as books, 
	read AS "read", 
	file.folder AS "folder" 
FROM #type/book
SORT file.name ASC
WHERE read = 2023
LIMIT 5
```

```dataview
TABLE WITHOUT ID
	file.folder AS ...
	file.link AS ...
	file.name AS ...
	file.etags AS ...
	length(file.outlinks) AS …
	length(file.inlinks) AS …
	length(file.etags) AS …
	dateformat(file.cday, "yyyy-MM-dd") AS Date
	dateformat(file.cday, "yyyy-LLL-dd") AS Date

FROM #target/forumzettelkasten  : when using tags
FROM "Books"                                : when using folders
FROM ""                                          : when using all folders
FROM #status/open OR #status/wip

SORT created DESC
SORT file.name ASC

WHERE read = 2023
WHERE status = "open"
WHERE contains(file.name,"LernOS Zettelkasten")
WHERE sketchnote != empty

LIMIT 3
```



---
# Back Matter
**Source**
<!-- Always keep a link to the source- --> 
- 

**Tasks**
<!-- What remains to be done with this note? --> 
- 

**Questions**
<!-- What remains for you to consider? --> 
- 

**Terms**
<!-- Links to definition pages. -->
- 

**References**

- [Query Types](https://github.com/blacksmithgu/obsidian-dataview/blob/master/docs/docs/queries/query-types.md)
- [Data Commands](https://github.com/blacksmithgu/obsidian-dataview/blob/master/docs/docs/queries/data-commands.md)

**Target**
<!-- Links to project note or externaly published content. -->
- [[Obsidian Knowledge Base]]

**Template Help**
<!-- Links to external help pages on GitHub. -->
- [Basic Template Structure](https://github.com/groepl/Obsidian-Templates#basic-template-structure)
- [How to Use Links](https://github.com/groepl/Obsidian-Templates#how-to-use-links)
- [How to Use Tags](https://github.com/groepl/Obsidian-Templates#how-to-use-tags)
- [How to Search Notes](https://github.com/groepl/Obsidian-Templates#how-to-search-notes)
- [Plugins Needed](https://github.com/groepl/Obsidian-Templates#obsidian-plugins-needed)
- [Find Latest Updates](https://github.com/groepl/Obsidian-Templates)

More about: 
https://github.com/blacksmithgu/obsidian-dataview/blob/master/docs/docs/queries/query-types.md
https://github.com/blacksmithgu/obsidian-dataview/blob/master/docs/docs/queries/data-commands.md

Source: 
https://github.com/groepl/Obsidian-Templates

