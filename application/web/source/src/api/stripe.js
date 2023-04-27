const postToStripe = (payment) => {
  const req = {
    method: "POST",
    headers: {
      Authorization: "Bearer sk_test_51LKnT3HQFzhXv47eB7VLHnT24DGSwcB1HUjTXOXWjJn9dsz3fydRinBstObtxjhwZrsifaof6TF7vQzzPDzt7AkQ00D8RtnyVz",
      "Content-Type": "application/x-www-form-urlencoded"
    },
    body: JSON.stringify({
      amount: payment.amount,
      currency: payment.currency,
      source: payment.source
    }),
  };
  fetch("https://api.stripe.com/v1/charges", req).then((response) =>
    console.log(response)
  );
}



