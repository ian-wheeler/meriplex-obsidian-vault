---
id: <% tp.date.now("YYYYMMDDHHmmss") %>
type: permanent
tags: []
---

# <%= tp.file.title %>
<% tp.user.prependDatetime(tp.file.title) %>
<% tp.file.cursor() %>