export interface Job {
  id: number;
  jobName: string;
  prompt: string;
  intervalSeconds: number;
  phoneNumber: string;
  isActive: boolean;
  lastRunAt?: Date;
}