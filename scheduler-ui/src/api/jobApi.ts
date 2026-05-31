const BASE_URL = "http://localhost:8989/api/scheduler";

export async function getJobs(token: string) {
  const res = await fetch(`${BASE_URL}/jobs`, {
    headers: { Authorization: `Bearer ${token}` },
  });
  return res.json();
}

export async function createJob(data: any, token: string) {
  return fetch(`${BASE_URL}/jobs`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify(data),
  });
}

export async function updateJob(id: number, data: any, token: string) {
  return fetch(`${BASE_URL}/jobs/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify(data),
  });
}

export async function deleteJob(id: number, token: string) {
  return fetch(`${BASE_URL}/jobs/${id}`, {
    method: "DELETE",
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });
}

export async function getHistory(id: number, token: string) {
  const res = await fetch(`${BASE_URL}/jobs/${id}/history`, {
    headers: { Authorization: `Bearer ${token}` },
  });
  return res.json();
}