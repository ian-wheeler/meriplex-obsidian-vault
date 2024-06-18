---
id: <% tp.date.now("YYYYMMDDHHmmss") %>
type: fleeting
tags:
  - zetel
  - fleeting
---

# <% tp.file.title %>
<% tp.user.prepend_datetime(tp.file.title) %>
<% tp.file.cursor() %>