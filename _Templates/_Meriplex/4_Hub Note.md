---
id: <% tp.date.now("YYYYMMDDHHmmss") %>
type: Structure Note
tags:
  - type/structure/moc
created: 2024-06-17T15:20
updated: 2024-06-28T14:51
---

# <%= tp.file.title %>
<% tp.user.prependDatetime(tp.file.title) %>
## Related Permanent Notes
<% tp.file.cursor() %>