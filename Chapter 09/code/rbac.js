

function authenticate(user, ctx) {
  if (!user.cred.matches(ctx.cred))
    reject()
}

function authorize(user, ctx)
if (!user.role(matches(ctx.access))
  reject()
}

