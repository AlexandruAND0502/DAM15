document.querySelectorAll('.rent-button').forEach(button => {
    button.addEventListener('click', function() {
        const instrumentId = this.getAttribute('data-instrument-id');
        
        alert('Ai închiriat instrumentul cu ID-ul ' + instrumentId);
    });
});
