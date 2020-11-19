class ShoppingList extends React.Component {
  render() {
    return (
      <div className="shopping-list">
        <h1>Lista della spesa per {this.props.name}</h1>
        <ul>
          <li>Instagram</li>
          <li>WhatsApp</li>
          <li>Oculus</li>
        </ul>
      </div>
    );
  }
}

// Esempio d'utilizzo: <ShoppingList name="Mark" />