async function storeValue() {

    let key = document.getElementById("key").value;
    let value = document.getElementById("value").value;
    let ttl = document.getElementById("ttl").value;
    // Validation
    if (key.trim() === "" || value.trim() === "" || ttl.trim() === "") {
        alert("Please fill all fields");
        return;
    }
    let response = await fetch(
        `/cache?key=${key}&value=${value}&ttl=${ttl}`,
        {
            method: "POST"
        }
    );

    let data = await response.text();
    alert(data);
}

async function getValue() {
    let key = document.getElementById("getKey").value;
    // Validation
    if (key.trim() === "") {
        alert("No key to fetch");
        return;
    }
    let response = await fetch(`/cache/${key}`);
    let data = await response.text();
    document.getElementById("result").innerText = data;
}

async function deleteValue() {
    let key = document.getElementById("deleteKey").value;
    // Check empty input
    if (key.trim() === "") {
        alert("No key to delete");
        return;
    }
    let response = await fetch(`/cache/${key}`, {
        method: "DELETE"
    });
    let data = await response.text();
    alert(data);
}

async function loadCache() {
    let response = await fetch("/cache/all");
    let data = await response.json();
    let list = document.getElementById("cacheList");
    list.innerHTML = "";
    data.forEach(item => {
        let li = document.createElement("li");
        li.innerText = item;
        list.appendChild(li);
    });
}

async function loadStats() {
    let response = await fetch("/cache/stats");
    let data = await response.json();
    document.getElementById("stats").innerText =
        `Hits: ${data.hits},
         Misses: ${data.misses},
         Evictions: ${data.evictions}`;
}