import { useState, useEffect } from "react";

const defaultForm = {
  jobName: "",
  description: "",
  phoneNumber: "",
  prompt: "",
  intervalSeconds: 0,
};

export default function JobModal({
  open,
  onClose,
  onSave,
  initialData,
}: any) {
  const [form, setForm] = useState(defaultForm);

  // 🔥 INI KUNCI NYA
  useEffect(() => {
    if (open) {
      if (initialData) {
        setForm(initialData); // EDIT
      } else {
        setForm(defaultForm); // CREATE (reset)
      }
    }
  }, [open, initialData]);

  if (!open) return null;

  return (
    <div className="fixed inset-0 bg-black/60 flex items-center justify-center">
      <div className="bg-[#111] p-4 rounded-lg w-96 text-sm">
        <h2 className="mb-3 font-semibold">
          {initialData ? "Edit Job" : "Buat Job"}
        </h2>

        <input
          placeholder="Nama Job"
          className="w-full mb-2 p-2 bg-[#222] rounded"
          value={form.jobName}
          onChange={(e) =>
            setForm({ ...form, jobName: e.target.value })
          }
        />

        <input
          placeholder="Nomor WhatsApp"
          className="w-full mb-2 p-2 bg-[#222] rounded"
          value={form.phoneNumber}
          onChange={(e) =>
            setForm({ ...form, phoneNumber: e.target.value })
          }
        />

        <textarea
          placeholder="Prompt AI"
          className="w-full mb-2 p-2 bg-[#222] rounded"
          value={form.prompt}
          onChange={(e) =>
            setForm({ ...form, prompt: e.target.value })
          }
        />

        <input
          type="number"
          className="w-full mb-3 p-2 bg-[#222] rounded"
          value={form.intervalSeconds}
          onChange={(e) =>
            setForm({
              ...form,
              intervalSeconds: Number(e.target.value),
            })
          }
        />

        <div className="flex justify-end gap-2">
          <button onClick={onClose}>Batal</button>
          <button
            className="bg-orange-500 px-3 py-1 rounded"
            onClick={() => onSave(form)}
          >
            Simpan
          </button>
        </div>
      </div>
    </div>
  );
}