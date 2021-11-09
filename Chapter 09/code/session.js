const session = new Session({
  secret: 'top secret',
  resave: false,
  saveUninitialized: false,
  cookie: {
    secure: true,
    maxAge: 20000
  }
})
