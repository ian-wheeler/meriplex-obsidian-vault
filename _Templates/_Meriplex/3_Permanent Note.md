---
id: <% tp.date.now("YYYYMMDDHHmmss") %>
type: Permanent Note
tags:
---

# <%= tp.file.title %>
<% tp.user.prependDatetime(tp.file.title) %>
<% tp.file.cursor() %>