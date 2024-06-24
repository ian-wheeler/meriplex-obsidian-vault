---
id: <% tp.date.now("YYYYMMDDHHmmss") %>
type: hub
tags:
  - moc
---

# <%= tp.file.title %>
<% tp.user.prependDatetime(tp.file.title) %>
## Related Permanent Notes
<% tp.file.cursor() %>